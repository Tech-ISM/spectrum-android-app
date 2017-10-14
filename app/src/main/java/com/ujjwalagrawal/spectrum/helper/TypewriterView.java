package com.ujjwalagrawal.spectrum.helper;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.widget.AppCompatEditText;
import android.text.InputType;
import android.util.AttributeSet;
import android.widget.EditText;

import java.util.LinkedList;
import java.util.Queue;

public class TypewriterView extends AppCompatEditText {

    private boolean isRunning = false;
    private long mTypeSpeed = 50;
    private long mDeleteSpeed = 60;
    private long mPauseDelay = 1000;

    private Queue<Repeater> mRunnableQueue = new LinkedList<>();

    private Runnable mRunNextRunnable = new Runnable() {
        @Override
        public void run() {
            runNext();
        }
    };

    public TypewriterView(Context context, AttributeSet attrs) {
        super(context, attrs);

        setBackgroundColor(Color.TRANSPARENT);
        setCursorAtEnd();
        setCursorVisible(true);
        setRawInputType(InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS | InputType.TYPE_TEXT_FLAG_MULTI_LINE);
    }

    public TypewriterView type(CharSequence text, long speed) {
        mRunnableQueue.add(new TextAdder(text, speed, mRunNextRunnable));
        if (!isRunning) runNext();
        return this;
    }

    public TypewriterView type(CharSequence text) {
        return type(text, mTypeSpeed);
    }

    public TypewriterView delete(CharSequence text, long speed) {
        mRunnableQueue.add(new TextRemover(text, speed, mRunNextRunnable));

        if (!isRunning) runNext();

        return this;
    }

    public TypewriterView delete(CharSequence text) {
        return delete(text, mDeleteSpeed);
    }

    public TypewriterView pause(long millis) {
        mRunnableQueue.add(new TypePauser(millis, mRunNextRunnable));

        if (!isRunning) runNext();

        return this;
    }

    public TypewriterView run(Runnable runnable) {
        mRunnableQueue.add(new TypeRunnable(runnable, mRunNextRunnable));

        if (!isRunning) runNext();
        return this;
    }

    public TypewriterView pause() {
        return pause(mPauseDelay);
    }

    private void setCursorAtEnd() {
        setSelection(getText().length());
    }

    private void runNext() {
        isRunning = true;
        Repeater next = mRunnableQueue.poll();

        if (next == null) {
            isRunning = false;
            return;
        }

        next.run();
    }

    private abstract class Repeater implements Runnable {
        protected Handler mHandler = new Handler();
        private Runnable mDoneRunnable;
        private long mDelay;

        public Repeater(Runnable doneRunnable, long delay) {
            mDoneRunnable = doneRunnable;
            mDelay = delay;
        }

        protected void done() {
            mDoneRunnable.run();
        }

        protected void delayAndRepeat() {
            mHandler.postDelayed(this, mDelay);
        }
    }

    private class TextAdder extends Repeater {

        private CharSequence mTextToAdd;

        public TextAdder(CharSequence textToAdd, long speed, Runnable doneRunnable) {
            super(doneRunnable, speed);

            mTextToAdd = textToAdd;
        }

        @Override
        public void run() {
            if (mTextToAdd.length() == 0) {
                done();
                return;
            }

            char first = mTextToAdd.charAt(0);
            mTextToAdd = mTextToAdd.subSequence(1, mTextToAdd.length());

            CharSequence text = getText();
            setText(text.toString() + first);
            setCursorAtEnd();
            delayAndRepeat();
        }
    }

    private class TextRemover extends Repeater {

        private CharSequence mTextToRemove;

        public TextRemover(CharSequence textToRemove, long speed, Runnable doneRunnable) {
            super(doneRunnable, speed);

            mTextToRemove = textToRemove;
        }

        @Override
        public void run() {
            if (mTextToRemove.length() == 0) {
                done();
                return;
            }


            char last = mTextToRemove.charAt(mTextToRemove.length() - 1);
            mTextToRemove = mTextToRemove.subSequence(0, mTextToRemove.length() - 1);

            CharSequence text = getText();

            try {
                if (text.charAt(text.length() - 1) == last) {
                    setText(text.subSequence(0, text.length() - 1));
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

            setCursorAtEnd();
            delayAndRepeat();
        }
    }

    private class TypePauser extends Repeater {

        boolean hasPaused = false;

        public TypePauser(long delay, Runnable doneRunnable) {
            super(doneRunnable, delay);
        }

        @Override
        public void run() {
            if (hasPaused) {
                done();
                return;
            }

            hasPaused = true;
            delayAndRepeat();
        }
    }

    private class TypeRunnable extends Repeater {

        Runnable mRunnable;

        public TypeRunnable(Runnable runnable, Runnable doneRunnable) {
            super(doneRunnable, 0);

            mRunnable = runnable;
        }

        @Override
        public void run() {
            mRunnable.run();
            done();
        }
    }
}
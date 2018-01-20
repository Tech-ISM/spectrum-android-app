package com.ujjwalagrawal.spectrum.login.view;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.ujjwalagrawal.spectrum.R;
import com.ujjwalagrawal.spectrum.helper.Keys;
import com.ujjwalagrawal.spectrum.helper.NetworkUtils;
import com.ujjwalagrawal.spectrum.helper.SharedPrefs;
import com.ujjwalagrawal.spectrum.login.data.LoginResponse;
import com.ujjwalagrawal.spectrum.login.presenter.LoginPresenter;
import com.ujjwalagrawal.spectrum.login.presenter.LoginPresenterImpl;
import com.ujjwalagrawal.spectrum.login.provider.RetrofitLoginHelper;
import com.ujjwalagrawal.spectrum.otp_verify.view.OtpActivity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity implements LoginView {

    private EditText editTextMobile,editTextName,editTextEmail;
    private TextView msgOtp;
    private ProgressBar progressBar;
    public String mobile,name,email;
    private LoginPresenter loginPresenter;
    private ImageView spectrum_logo;
    private SharedPrefs sharedPrefs;
    private LinearLayout layout_name,layout_mobile,layout_email;
    Dialog dialog;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        sharedPrefs = new SharedPrefs(this);
        initialise();

    }

    public void initialise() {
        context=this;
        editTextMobile = (EditText) findViewById(R.id.input_mobile);
        editTextName = (EditText) findViewById(R.id.input_name);
        final RelativeLayout relative_layout_parent = findViewById(R.id.relative_layout_parent);
        editTextEmail = (EditText) findViewById(R.id.input_email);
        layout_name = (LinearLayout) findViewById(R.id.layout_name);
        layout_email = (LinearLayout) findViewById(R.id.layout_email);
        layout_mobile = (LinearLayout) findViewById(R.id.layout_mobile);
        msgOtp = (TextView) findViewById(R.id.otp_msg);
        spectrum_logo = (ImageView) findViewById(R.id.spectrum_logo);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

//        Glide.with(this).load(R.drawable.login_background).asBitmap().into(new SimpleTarget<Bitmap>(relLayoutWidth, relLayoutHeight) {
//            @Override
//            public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
//                Drawable drawable = new BitmapDrawable(context.getResources(), resource);
//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
//                    relative_layout_parent.setBackground(drawable);
//                }
//            }
//        });

        Glide.with(this).load(R.drawable.spectrum_circle).into(spectrum_logo);
        editTextMobile.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (s.length() == 10) {
                    hideKeyboard();
                }
            }
            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    public void proceed(View v) {
        name = editTextName.getText().toString().trim();
        mobile = editTextMobile.getText().toString().trim();
        email = editTextEmail.getText().toString().trim();

        if (mobile.isEmpty() || name.isEmpty() || email.isEmpty()) {
            showProgressBar(false);
            showError("Fields cannot be empty");
        }
        if(mobile.length()!=10){
            Toast.makeText(LoginActivity.this, "YOU HAVE ENTERED AN INCORRECT MOBILE NUMBER!",
                    Toast.LENGTH_LONG).show();
        }
        else if(emailInvalid(email)){
            Toast.makeText(LoginActivity.this, "ENTER CORRECT EMAIL ID!",
                    Toast.LENGTH_LONG).show();
        }
        else {

            loginPresenter = new LoginPresenterImpl(this, new RetrofitLoginHelper());
            loginPresenter.getLoginData(name,mobile,email);
            hideKeyboard();
        }

    }

    @Override
    public void showProgressBar(boolean show) {
        if (show) {
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.GONE);
        }
    }


    @Override
    public void showLoginStatus(LoginResponse loginDataResponse) {
            msgOtp.setVisibility(View.VISIBLE);

            layout_name.setVisibility(View.GONE);
            layout_email.setVisibility(View.GONE);
            layout_mobile.setVisibility(View.GONE);
            Intent i = new Intent(LoginActivity.this, OtpActivity.class);
            i.putExtra(Keys.KEY_MOBILE, mobile);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(i);
            sharedPrefs.setMobile(mobile);
            sharedPrefs.setUsername(name);
            sharedPrefs.setEmailId(email);
            sharedPrefs.setAccessToken(loginDataResponse.getToken());
            finish();

    }

    @Override
    public void showError(String message) {
        Toast.makeText(LoginActivity.this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void checkNetwork() {
        if(!NetworkUtils.isNetworkAvailable(this)){
            dialog = new Dialog(this);
            dialog.setContentView(R.layout.activity_rules__dialog_box);
            Button btn = (Button) dialog.findViewById(R.id.dialog_button);
            TextView rules5 = (TextView) dialog.findViewById(R.id.rules5);
            btn.setText("Retry");
            rules5.setText("No internet connection.Please try again.");
            dialog.setTitle("Connectivity Failed");
            dialog.setCancelable(false);
            dialog.show();
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    loginPresenter = new LoginPresenterImpl(LoginActivity.this, new RetrofitLoginHelper());
                    loginPresenter.getLoginData(name,mobile,email);
                    dialog.dismiss();
                }
            });
        }
    }

    private void hideKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public boolean emailInvalid(String email) {
        Pattern pattern;
        Matcher matcher;

        final String EMAIL_PATTERN =
                "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(email);
        boolean a = matcher.matches();
        return !a;
    }

}

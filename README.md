# spectrum-android-app
The Android app for Spectrum '18.

**Guidelines to use git in this project** 

1. Clone the project from https://github.com/Tech-ISM/spectrum-android-app#spectrum-android-app
Use git bash or terminal in local computer and use these commands
2. git checkout -b yourname_dev (This will make a new branch on your local copy)
3. Code and add new modules 
4. git add . (This will add all new files that you created to git)
5. git commit -am “XYZ Module added or ABC bug fixed”
6. git push origin yourname_dev

Follow the below steps if you want to merge with master branch 

7. git checkout master (Switch to local master)
8. git pull origin master (Updates the local master branch from github master branch) 
9. git checkout yourname_dev (Switch to local yourname_dev)
10.  git merge master (Merge master code to your local branch)
11. Resolve conflicts if any (few conflicts may be there in URLs file or any other file) 
12. git push origin yourname_dev.

Now your branch is fully updated.Update master now

13. git checkout master 
14. git merge yourname_dev (Merge master code to your local branch)

No conflicts should be there now as we had already fixed conflicts in another branch.

15. git push origin master (Update origin master in Github)
16.  Relax if everything is done properly.

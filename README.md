![logo_removed (git)](https://user-images.githubusercontent.com/68552044/88162329-dfd8d680-cc19-11ea-9c48-c39950d69a0a.png)

 # What is it about?
 
Frisbeeh is an android platform application used to calculate and to view user scores in frisbeegolf sport. It's to create more simplified and efficient user interface to keep count of scores. This application is a project of mine, I created this app for I wanted a simple user interface to keep track of my points. I also wanted to practice my skills with developing an application from real life point of view. This project was made with Android Studio platform and java programming language.

## Log in / Log out 
![oie_GCi5hIVi1bZ8](https://user-images.githubusercontent.com/68552044/88166487-013cc100-cc20-11ea-9270-01da3743214d.gif)

In order to use Frisbeeh app you need to sign up creating your own credentials or login with existing credentials. User credential verification is done through Google Firebase email/password authentication method. Frisbeeh stores and collects the data inputted by the user in Firebase database. 
Enabling "remember me" the app will make an temporary save file to your local device memory and will be erased once logged out. The save file is set to private, only the Frisbeeh app can use that information. 

## Creating new account

![oie_oW91JAOV7WgA](https://user-images.githubusercontent.com/68552044/88167902-38ac6d00-cc22-11ea-80bd-d361976637dd.gif)

Creating new user account is simple.
1. Input desired credentials
2. Press the Create -button.

The application will now check from the Google Firebase database if these user credentials are in use. Upon succesfull creation you will be redirected to the login view. In case of any issues the app will make a push notification stating the caused issue, user account will not be created until the progress is succesfull.
If you wish to test Frisbeeh without creating your own account please use the test user -account I've created:

**Username:** testuser@gmail.com

**password:** test123

**nickname:** testuser

## New game

### Instructions

![oie_XproMfyy2Bug](https://user-images.githubusercontent.com/68552044/88170111-cf2e5d80-cc25-11ea-9d71-cb4301fddd89.gif)

1. Begin the game with adding a score value and press Begin -button.
2. Add/Decrease points with dedicated buttons below.

- Your inputted scores can be seen in the view above and the total count of points at the top.

### Wrong input/ issue handling

![oie_DekWeEFJPOky](https://user-images.githubusercontent.com/68552044/88170390-47951e80-cc26-11ea-87ba-0b474edd0714.gif)


You **can not save empty score**. Frisbeeh will guide you with push notifications if any issues comes up.

# The Download link

Currently Frisbeeh is not in Google Play store although my intention is to add it there.
Here is the Dropbox download link for the apk-file:
https://www.dropbox.com/s/x01dl5lrywmmbfh/Frisbeeh.apk?dl=0

Please keep in mind this is a student made project.

Thank you!

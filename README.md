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

Frisbeeh will guide you with push notifications in case wrong button or input has been set.

## Saving score

![oie_0YFcqsZjKLIX](https://user-images.githubusercontent.com/68552044/88268400-10347980-ccdb-11ea-803e-935095b22458.gif)

Frisbeeh will automatically fetch your total score and show it in the bottom, make sure it is right.
1. Add your username, name of the course, and the date. (Note: be precise when writing the username, the score details will be saved as they've inputted).
2. Save the score by pressing Save Score -button.

## Viewing saved scores

You can view your saved scores in two ways, here is the first way: saving score and then viewing the score list.

![oie_40yAmsrfSNEW](https://user-images.githubusercontent.com/68552044/88269003-f6476680-ccdb-11ea-9caf-117c084765cf.gif)

This is the second way. Navigating from main menu to scores view you are required to write the desired username. Checking the remember username box will save your nickname for the future until logged out. Next time clicking scores Frisbeeh will automatically direct you to your saved scores list.

![oie_0NxNmz3sDshj](https://user-images.githubusercontent.com/68552044/88269332-81c0f780-ccdc-11ea-907c-949610dde66e.gif)


Please note that you **can not save empty score**. Frisbeeh will guide you with push notifications in case of any issues.

# The Download link

Currently Frisbeeh is not in Google Play store although my intention is to add it there.
Here is the Dropbox download link for the apk-file:
https://www.dropbox.com/s/x01dl5lrywmmbfh/Frisbeeh.apk?dl=0

Please keep in mind this is a student made project.

Thank you!

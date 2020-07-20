package com.example.Frisbeeh;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import gr.net.maroulis.library.EasySplashScreen;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        EasySplashScreen config = new EasySplashScreen(SplashScreen.this)
                .withFullScreen()
                .withTargetActivity(LoginAct.class)
                .withSplashTimeOut(3800)
                .withBackgroundColor(Color.parseColor("#424143"))
                .withLogo(R.drawable.logo_removed);

        View easySplashScreen = config.create();
        setContentView(easySplashScreen);
    }
}
package com.example.Frisbeeh;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MenuActivity extends AppCompatActivity {
    public Button oldscoresbtn, newgamebtn;
    public FloatingActionButton logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        oldscoresbtn = findViewById(R.id.oldscorebtn);
        newgamebtn = findViewById(R.id.newgamebtn);
        logout = findViewById(R.id.logoutBtn);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = getSharedPreferences("checkbox", MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("remember", "false");
                editor.apply();

                SharedPreferences preferences1 = getSharedPreferences("checkbox2", MODE_PRIVATE);
                SharedPreferences.Editor editor2 = preferences1.edit();
                editor2.putString("remembernick", "false");
                editor2.apply();

                finish();
            }
        });


        oldscoresbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savscores();
            }
        });

        newgamebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newgam();
            }
        });
    }

    public void savscores(){
        Intent intents = new Intent(this, FillerActivity.class);
        startActivity(intents);
    }

    public void newgam(){
        Intent intent0 = new Intent(this, MainActivity.class);
        startActivity(intent0);
    }
}
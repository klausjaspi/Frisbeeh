package com.example.Frisbeeh;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class FillerActivity extends AppCompatActivity {
    public EditText fillerinfoText;
    public Button sendbtn;
    public static final String EXTRA_TEXT3 = "com.example.Frisbeeh.FillerActivity.EXTRA_TEXT3";
    CheckBox remember2;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filler);

        fillerinfoText = findViewById(R.id.fillerinfoTxt);
        sendbtn = findViewById(R.id.sendtn);
        remember2 = findViewById(R.id.rememberbox);


        SharedPreferences preferences1 = getSharedPreferences("checkbox2", MODE_PRIVATE);
        String nick = preferences1.getString("remembernick", "");
        if(nick.equals("false")){

        }
        else if(nick.equals("")) {

        }
        else {
            Intent jep = new Intent(FillerActivity.this, SavedScores.class);
            startActivity(jep);

        }

        remember2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (remember2.isChecked()) {

                    String hmm = fillerinfoText.getText().toString();
                    SharedPreferences preferences1 = getSharedPreferences("checkbox2", MODE_PRIVATE);
                    SharedPreferences.Editor editor2 = preferences1.edit();
                    editor2.putString("remembernick", "" + hmm);
                    editor2.apply();

                    Toast.makeText(FillerActivity.this, "Nickname saved", Toast.LENGTH_SHORT).show();
                } else if(!remember2.isChecked()){

                }
            }
        });




        sendbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(remember2.isChecked()){
                    savscor();
                }
                else{
                    notchecked();
                }

            }
        });
    }

    public void savscor(){
        Intent save = new Intent(this, SavedScores.class);
        SharedPreferences preferences3 = getSharedPreferences("checkbox2", MODE_PRIVATE);
        String info = preferences3.getString("remembernick", "");
        save.putExtra(EXTRA_TEXT3, info);
        startActivity(save);
    }
    public void notchecked(){
        Intent not = new Intent(this, SavedScores.class);
        String notsaved = fillerinfoText.getText().toString();
        not.putExtra(EXTRA_TEXT3, notsaved);
        startActivity(not);
    }
}
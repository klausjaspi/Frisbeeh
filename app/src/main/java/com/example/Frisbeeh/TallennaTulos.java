package com.example.Frisbeeh;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class TallennaTulos extends AppCompatActivity {

    public static final String EXTRA_TEXT2 = "com.example.Frisbeeh.TallennaTulos.EXTRA_TEXT2";
    public EditText editcoursename,editTextDate, usernameTxt;
    public TextView totalscoreView, savednameView, totalTxtt;
    public Button savebtn, savedbtn;
    String coursename, date, userscore, nickname;
    private FirebaseDatabase mDatabase;
    DatabaseReference reff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tallenna_tulos);

        editcoursename = findViewById(R.id.editcoursename);
        editTextDate = findViewById(R.id.editTextDate);
        totalscoreView = findViewById(R.id.totalscoreView);
        savednameView = findViewById(R.id.savednameView);
        savebtn = findViewById(R.id.savebtn);
        savedbtn = findViewById(R.id.savedbtn);
        totalTxtt = findViewById(R.id.totalTxt);
        usernameTxt = findViewById(R.id.usernameTxt);


        Intent intent = getIntent();
        final String text = intent.getStringExtra(MainActivity.EXTRA_TEXT);
        totalscoreView.setText(text);


        savedbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(nickname)) {
                    Toast.makeText(TallennaTulos.this, "Please enter  a nickname!", Toast.LENGTH_SHORT).show();
                } if(TextUtils.isEmpty(coursename)){
                    Toast.makeText(TallennaTulos.this, "Please enter a course name!", Toast.LENGTH_SHORT).show();
                } if (TextUtils.isEmpty(date)) {
                    Toast.makeText(TallennaTulos.this, "Please enter the date!", Toast.LENGTH_SHORT).show();
                }
                else {
                    savedscor();
                }
            }
        });

        savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                coursename = editcoursename.getText().toString();
                date = editTextDate.getText().toString();
                nickname = usernameTxt.getText().toString().trim();

                if(TextUtils.isEmpty(nickname)) {
                        Toast.makeText(TallennaTulos.this, "Please enter a nickname!", Toast.LENGTH_SHORT).show();
                } if(TextUtils.isEmpty(coursename)){
                        Toast.makeText(TallennaTulos.this, "Please enter a course name!", Toast.LENGTH_SHORT).show();
                } if (TextUtils.isEmpty(date)) {
                        Toast.makeText(TallennaTulos.this, "Please enter the date!", Toast.LENGTH_SHORT).show();
                } else {
                    reff = FirebaseDatabase.getInstance().getReference().child(nickname).child("Saved scores");
                    mDatabase = FirebaseDatabase.getInstance();
                    DatabaseReference mref = mDatabase.getReference();
                    userscore = mref.push().getKey();
                    Pelitiedot peltiedot = new Pelitiedot(coursename, date, text);

                    reff.push().setValue(peltiedot);
                    Toast.makeText(TallennaTulos.this, "Score saved successfully", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    public void savedscor(){
        Intent intent8 = new Intent(this, SavedScores.class);
        String k = usernameTxt.getText().toString().trim();
        intent8.putExtra(EXTRA_TEXT2, k);
        startActivity(intent8);
    }
}
package com.example.Frisbeeh;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class LoginAct extends AppCompatActivity {
    public Button kirjaudu, Uusi_kayttaja;
    public EditText kayttaja, salasana, uusikayttajanimi, uusikayttajasalasana;
    private FirebaseAuth mAuth;
    CheckBox remember;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();

        kayttaja = findViewById(R.id.usernametxt);
        salasana = findViewById(R.id.editTextTextPassword);
        kirjaudu = findViewById(R.id.loginBtn);
        Uusi_kayttaja = findViewById(R.id.uusikayttajabtn);
        uusikayttajanimi = findViewById(R.id.uusikayttajanimi);
        uusikayttajasalasana = findViewById(R.id.uusikayttajasalasana);
        remember = findViewById(R.id.rememberbox);

        mAuth = FirebaseAuth.getInstance();

        SharedPreferences preferences = getSharedPreferences("checkbox", MODE_PRIVATE);
        String checkbox = preferences.getString("remember", "");
        if(checkbox.equals("true")){
            Intent intents = new Intent(LoginAct.this, MenuActivity.class);
            startActivity(intents);
        } else if(checkbox.equals("false")){
            //Toast.makeText(this,"Please sign in.", Toast.LENGTH_SHORT).show();
        }

        Uusi_kayttaja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tee_kayttaja();
            }
        });

        kirjaudu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AllowUserToLogin();
            }
        });


        remember.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(remember.isChecked()){

                    SharedPreferences preferences = getSharedPreferences("checkbox", MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("remember", "true");
                    editor.apply();


                } else if(!remember.isChecked()){
                    SharedPreferences preferences = getSharedPreferences("checkbox", MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("remember", "false");
                    editor.apply();

                }
            }
        });



    }

    private void AllowUserToLogin(){
        final String uusinimi = kayttaja.getText().toString().trim();
        final String uusisalas = salasana.getText().toString().trim();

        if(TextUtils.isEmpty(uusinimi)){
            Toast.makeText(LoginAct.this, "Please enter email!", Toast.LENGTH_SHORT).show();
        } if(TextUtils.isEmpty(uusisalas)){
            Toast.makeText(LoginAct.this, "Please enter password!", Toast.LENGTH_SHORT).show();
        } else{
            mAuth.signInWithEmailAndPassword(uusinimi, uusisalas).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        MainActivty();
                    } else{
                        String message1 = task.getException().toString();
                        Toast.makeText(LoginAct.this,"Error: " + message1, Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    public void tee_kayttaja(){
        Intent intent3 = new Intent(this, TeeKayttaja.class);
        startActivity(intent3);
    }

    public void MainActivty(){
        Intent intent5 = new Intent(this, MenuActivity.class);
        startActivity(intent5);
    }
}
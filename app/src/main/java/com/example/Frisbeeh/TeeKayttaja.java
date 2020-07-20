package com.example.Frisbeeh;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

public class TeeKayttaja extends AppCompatActivity {

    public EditText uusikayttajanimi, uusikayttajasalasana, nicknameTxt;
    public Button uusirekisteri;
    public DatabaseReference Frisbeeh;
    private FirebaseAuth mAuth;
    private ProgressDialog loadingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tee_kayttaja);



        mAuth = FirebaseAuth.getInstance();


        uusikayttajanimi = findViewById(R.id.uusikayttajanimi);
        uusikayttajasalasana = findViewById(R.id.uusikayttajasalasana);
        uusirekisteri = findViewById(R.id.uusirekisteri);
        loadingBar = new ProgressDialog(this);
        nicknameTxt = findViewById(R.id.nicknameTxt);



        uusirekisteri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                final String uusinimi = uusikayttajanimi.getText().toString().trim();
                final String uusisalas = uusikayttajasalasana.getText().toString().trim();


                if(TextUtils.isEmpty(uusinimi)){
                    Toast.makeText(TeeKayttaja.this, "Please enter email!", Toast.LENGTH_SHORT).show();
                } if(TextUtils.isEmpty(uusisalas)){
                    Toast.makeText(TeeKayttaja.this, "Please enter password!", Toast.LENGTH_SHORT).show();
                } else{
                    loadingBar.setTitle("Creating new account");
                    loadingBar.setMessage("Just a moment please!");
                    loadingBar.setCanceledOnTouchOutside(true);
                    loadingBar.show();

                    mAuth.createUserWithEmailAndPassword(uusinimi, uusisalas).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if(task.isSuccessful()){

                                Toast.makeText(TeeKayttaja.this, "User created successfully",Toast.LENGTH_SHORT).show();
                                loadingBar.dismiss();

                                Loginact();

                            }

                            else{
                                String message = task.getException().toString();
                                Toast.makeText(TeeKayttaja.this, "Creating user failed: " + message,Toast.LENGTH_SHORT).show();

                                loadingBar.dismiss();
                            }
                        }
                    });
                }



            }

        });



        }
        public void Loginact(){
            Intent intent4 = new Intent(this, LoginAct.class);
            startActivity(intent4);
    }

}



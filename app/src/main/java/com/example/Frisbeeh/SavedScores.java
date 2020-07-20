package com.example.Frisbeeh;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.ArrayList;
import java.util.Collections;

public class SavedScores extends AppCompatActivity {
    Query databaseReference;
    public Button mainmenubtn;
    public FloatingActionButton logoutBtn2;
    public TextView savednameView;
    public ListView savedscoresLV;
    public EditText usernameTxt;
    ArrayAdapter<String> arrayAdapter;
    ArrayList<String> arrayList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_scores);

        savednameView = findViewById(R.id.savednameView);
        savedscoresLV = (ListView) findViewById(R.id.savedscoresLV);
        usernameTxt = findViewById(R.id.usernameTxt);
        mainmenubtn = findViewById(R.id.mainmenubtn);
        logoutBtn2 = findViewById(R.id.logoutBtn2);



        SharedPreferences result = getSharedPreferences("checkbox2", MODE_PRIVATE);
        String okay = result.getString("remembernick", "");
        

        logoutBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = getSharedPreferences("checkbox", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor1 = preferences.edit();
                editor1.putString("remember", "false");
                editor1.apply();

                SharedPreferences preferences2 = getSharedPreferences("checkbox2", MODE_PRIVATE);
                SharedPreferences.Editor editor2 = preferences2.edit();
                editor2.putString("remembernick", "false");
                editor2.apply();


                byebye();
            }
        });

        mainmenubtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startagain();
            }
        });
        


        Intent intentt = getIntent();

        String text3 = intentt.getStringExtra(TallennaTulos.EXTRA_TEXT2);


        if(text3 == null){
            databaseReference = FirebaseDatabase.getInstance().getReference(okay);
        } else if(okay.equals("")){
            databaseReference = FirebaseDatabase.getInstance().getReference(text3);
        } else{
            databaseReference = FirebaseDatabase.getInstance().getReference(okay);
        }

        if(text3 == null){
            savednameView.setText(okay);
        } if(okay.equals("")){
            savednameView.setText(text3);
        } else{
            savednameView.setText(okay);
        }


            arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayList);
        savedscoresLV.setAdapter(arrayAdapter);



        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                for(DataSnapshot snapshot1 : snapshot.getChildren()) {
                    Pelitiedot value = snapshot1.getValue(Pelitiedot.class);
                    assert value != null;
                    arrayList.add(value.getCoursename() + ", " + value.getDate() + ", points:  " + value.getUserscore());
                    arrayAdapter.notifyDataSetChanged();
                    Collections.sort(arrayList);
                }
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    public void startagain(){
        Intent again = new Intent(this, MenuActivity.class);
        startActivity(again);
    }
    public void byebye(){
        Intent bye = new Intent(this, LoginAct.class);
        startActivity(bye);
    }
}
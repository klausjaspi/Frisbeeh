package com.example.Frisbeeh;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button incbutton, decbutton, okbtn, tallennabtn;
    public static final String EXTRA_TEXT = "com.example.Frisbeeh.MainActivity.EXTRA_TEXT";
    private ListView lvtaulu;
    private EditText numeroTxt;
    public ArrayList<Integer> Pojot;
    ArrayAdapter<Integer> adapter;
    public TextView totalTxtt;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        incbutton = findViewById(R.id.incbutton);
        decbutton =  findViewById(R.id.decbutton);
        okbtn = findViewById(R.id.OKbtn);
        tallennabtn = findViewById(R.id.tallennabtn);

        lvtaulu = findViewById(R.id.lvtaulu);
        numeroTxt = findViewById(R.id.numeroTxt);
        totalTxtt = findViewById(R.id.totalTxt);
        final TextView result = (TextView) findViewById(R.id.totalscoreView);

        Pojot = new ArrayList<Integer>();
        adapter = new ArrayAdapter<Integer>(MainActivity.this, android.R.layout.simple_list_item_1, Pojot);

        lvtaulu.setAdapter(adapter);

        okbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Pojot.size() == 0) {
                    try {
                        int k = Integer.parseInt(numeroTxt.getText().toString());
                        Pojot.add(k);
                        totalTxtt.setText("" + k);
                        adapter.notifyDataSetChanged();

                    }
                    catch (Exception e){
                        if(Pojot.size()== 0) {
                            Toast.makeText(MainActivity.this, "Please enter a number first!", Toast.LENGTH_SHORT).show();
                        } else{
                                Toast.makeText(MainActivity.this, "Only first number with this button, press 'add' instead!", Toast.LENGTH_SHORT).show();
                            }
                        }
                }

            }
        });

        incbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int q = Integer.parseInt(numeroTxt.getText().toString());
                    int j = Pojot.get(Pojot.size() - 1);
                    int lis = j + q;
                    Pojot.add(lis);
                    totalTxtt.setText("" + lis);
                    adapter.notifyDataSetChanged();
                }
                catch (Exception e){
                    if(Pojot.size()== 0) {
                        Toast.makeText(MainActivity.this, "Please enter a number first with 'begin' button!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        decbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int q = Integer.parseInt(numeroTxt.getText().toString());

                    int w = Pojot.get(Pojot.size() - 1);
                    int vah = w - q;
                    Pojot.add(vah);
                    totalTxtt.setText("" + vah);
                    adapter.notifyDataSetChanged();
                }
                catch (Exception e){
                    if(Pojot.size()== 0) {
                        Toast.makeText(MainActivity.this, "Please enter a number first with 'begin' button!", Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });

        tallennabtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Pojot.size()==0){
                    Toast.makeText(MainActivity.this, "Can't save empty score.", Toast.LENGTH_SHORT).show();
                }
                else {
                    savescore();
                }
            }
        });

    }
    public void savescore(){
        Intent intent7 = new Intent(this, TallennaTulos.class);
        String s = totalTxtt.getText().toString().trim();
        intent7.putExtra(EXTRA_TEXT,s);
        startActivity(intent7);
    }
}
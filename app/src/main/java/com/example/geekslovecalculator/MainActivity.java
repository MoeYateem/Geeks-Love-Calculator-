package com.example.geekslovecalculator;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity{
    Spinner spinner;
    ImageView imgView;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = (Spinner) findViewById(R.id.lang);
        ArrayAdapter<CharSequence> ad = ArrayAdapter.createFromResource(this,R.array.languages,android.R.layout.simple_spinner_item);
        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(ad);


    }
    public void generate(View v){
        TextView text = findViewById(R.id.output);
        EditText input = findViewById(R.id.name);
        Random random = new Random();
        int perc = random.nextInt(100);

        text.setText(Integer.toString(perc)+"%");



    }



}
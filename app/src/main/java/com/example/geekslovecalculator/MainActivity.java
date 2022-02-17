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

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    int position;
    Spinner spinner;
    ImageView imgView;
    boolean selected[] = new boolean[9];
    int[] numbers = new int[9];

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = (Spinner) findViewById(R.id.lang);
        ArrayAdapter<CharSequence> ad = ArrayAdapter.createFromResource(this,R.array.languages,android.R.layout.simple_spinner_item);
        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(ad);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String lang = spinner.getSelectedItem().toString();
        if(imgView != null){
            imgView.setImageResource(0);
        }
        selected[i] = true;
        position = i;
        imgView = (ImageView) findViewById(R.id.i1);

        if(lang.equals("JAVA")){
            imgView.setImageResource(R.drawable.jav);
        }
        else if(lang.equals("Python")){
            imgView.setImageResource(R.drawable.python);
        }
        else if(lang.equals("C")){
            imgView.setImageResource(R.drawable.c);
        }
        else if(lang.equals("C++")){
            imgView.setImageResource(R.drawable.cp);
        }
        else if(lang.equals("C#")){
            imgView.setImageResource(R.drawable.csh);
        }
        else if(lang.equals("JavaScript")){
            imgView.setImageResource(R.drawable.js);
        }
        else if(lang.equals("Ruby")){
            imgView.setImageResource(R.drawable.ruby);
        }
        else if(lang.equals("Kotlin")){
            imgView.setImageResource(R.drawable.kotlin);
        }
        else{
            imgView.setImageResource(0);
        }
        generate();
        fillTable(adapterView, numbers);
    }



    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
    public void generate(){
        TextView text = findViewById(R.id.output);
        EditText input = findViewById(R.id.name);
        Random random = new Random();
        int perc = random.nextInt(100);

        text.setText(Integer.toString(perc)+"%");
        numbers[position] = perc;
    }
    public void generate(View v){
        TextView text = findViewById(R.id.output);
        EditText input = findViewById(R.id.name);
        Random random = new Random();
        int perc = random.nextInt(100);

        text.setText(Integer.toString(perc)+"%");
        numbers[position] = perc;
    }

    public void fillTable(AdapterView parent, int[] percentages){
        TextView vw = findViewById(R.id.table);
        StringBuilder txt = new StringBuilder();
        String lang;

        for(int i = 0; i < 8; i++){
            //lang = "testing";
            lang = parent.getItemAtPosition(i).toString();
            for(int j = 0; j <= 16 - lang.length(); j++){
                lang += " ";
            }
            if(selected[i] && percentages[i]!= 0) txt.append("love result of \t\t\t\t" + lang + "\t\t is:" +percentages[i] + "\n");
        }

        vw.setText(txt.toString());
    }



}
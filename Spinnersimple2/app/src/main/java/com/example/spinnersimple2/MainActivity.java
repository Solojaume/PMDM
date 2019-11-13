package com.example.spinnersimple2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner sGenero =(Spinner) findViewById(R.id.spinnerGenero);

        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,genero);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sGenero.setAdapter(adapter);
    }
}

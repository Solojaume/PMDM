package com.example.seleccionsobredoslist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {
    Spinner sGenero ;
    private String[] genero = {"Ciencia","Biologia","Teraplanismo"};
  private Libro[][] datos = new Libro[][]{{new Libro("Ciencia","Alguien", R.drawable.indice), new Libro("Biologia","Un Biolog@",R.drawable.indice)}};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         sGenero = (Spinner) findViewById(R.id.spinnerGenero);


        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,genero);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sGenero.setAdapter(adapter);

        sGenero.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}

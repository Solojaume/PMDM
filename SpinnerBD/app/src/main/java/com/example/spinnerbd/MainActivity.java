package com.example.spinnerbd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import com.example.spinnerbd.Controler.adapter.AdaptadorPersona;
import com.example.spinnerbd.model.Persona;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private List<Persona> listaPersonas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listaPersonas = new ArrayList<Persona>();
        createPersona();
        Spinner spinner =findViewById(R.id.spinner);
        AdaptadorPersona adaptador = new AdaptadorPersona(this,R.layout.desplegador_persona,  listaPersonas);

        spinner.setAdapter(adaptador);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {


            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

             System.out.println("===========================================================Debug: "+position);
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

    }

    private void createPersona(){
        Persona p1= new Persona("Enzo","Ferrari",80,R.drawable.enzo);
        listaPersonas.add(p1);
        Persona p2= new Persona("Ferruccio","Lamborghini",80,R.drawable.ferruccio);
        listaPersonas.add(p2);

    }
}

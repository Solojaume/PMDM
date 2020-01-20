package com.example.spinnerbd;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import com.example.spinnerbd.Controler.adapter.AdaptadorPersona;
import com.example.spinnerbd.Controler.adapter.Controler.helper.DataBaseHelper;
import com.example.spinnerbd.model.Persona;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private List<Persona> listaPersonas;
    DataBaseHelper cliDBh= null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listaPersonas = new ArrayList<Persona>();
        cliDBh = new DataBaseHelper(this);

        this.cliDBh.open(); //Abrimos la base de datos en modo escritura
        //En caso de abrir de forma correcta la base de datos
        if (this.cliDBh!= null) {
            System.out.println("=========================Debug");
            // Introducimos 3 clientes de ejemplo data
            for (int cont = 1; cont <= 3; cont++) {
                //Creamos los datos

                String nombre = "cli" + cont;
                String apellido = "ape" + cont;
                int edad = cont;
                //Introducimos los datos en la tabla Clientes
                cliDBh.insertItem(cont,nombre,apellido,edad);
            }
        }
        this.cliDBh.close();
        cargarPersona();
        Spinner spinner =findViewById(R.id.spinner);
        AdaptadorPersona adaptador = new AdaptadorPersona(this,R.layout.desplegador_persona,  listaPersonas);

        spinner.setAdapter(adaptador);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {


            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

    }


    private void cargarPersona(){
//        Persona p1= new Persona("Enzo","Ferrari",80,R.drawable.enzo);
//        listaPersonas.add(p1);
//        Persona p2= new Persona("Ferruccio","Lamborghini",70,R.drawable.ferruccio);
//        listaPersonas.add(p2);
       Cursor c=cliDBh.getClients();
        do {
            listaPersonas.add( new Persona( c.getString(0),c.getString(1),c.getInt(2)));
        } while (c.moveToNext());


    }
}

package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.proyectofinal.controller.AdaptadorGenero;
import com.example.proyectofinal.model.Genero;
import com.example.proyectofinal.model.Preferencias;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;

public class GeneroActivity extends AppCompatActivity {
    private List<Preferencias> preferencias= new ArrayList<Preferencias>();
//    private Genero[] generos={new Genero(1,"Rock"), new Genero(2,"Balada"),new Genero(3,"Pop")};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genero);

        ListView lstGeneros = (ListView) findViewById(R.id.listViewGeneros);
        AdaptadorGenero adaptador = new AdaptadorGenero(this, MainActivity.generosList);
        lstGeneros.setAdapter(adaptador);
        lstGeneros.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Boolean bool = true;//Esto dice si el genero esta o no en la lista de preferencias de usuario
                for (int i = 0; i < preferencias.size(); i++) {
                    if(preferencias.get(i).getGeneroId()==MainActivity.generosList.get(position).getId())
                        bool=false;
                }
                if(bool)
                    preferencias.add(new Preferencias('1',MainActivity.idUser,MainActivity.generosList.get(position).getId()));
            }
        });


    }
    public void guardarPreferenciasUsuario(View view){//onclick button
        Intent intent = new Intent (this,PrincipalActivity.class);
        startActivity(intent);
    }
}

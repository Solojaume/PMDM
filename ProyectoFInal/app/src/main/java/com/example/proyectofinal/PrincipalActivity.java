package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.proyectofinal.controller.AdaptadorGenero;
import com.example.proyectofinal.model.Genero;
import com.example.proyectofinal.model.Preferencias;

import java.util.ArrayList;
import java.util.List;

public class PrincipalActivity extends AppCompatActivity {
    private Preferencias[] preferencias;

    List<Genero> generosUsuario= new ArrayList<Genero>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        filtrarPreferenciasGenero();
        ListView lstGeneros = (ListView)findViewById(R.id.listViewGeneros);
        AdaptadorGenero adaptador = new AdaptadorGenero(this,generosUsuario);
        lstGeneros.setAdapter(adaptador);
        lstGeneros.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String mensaje = "Id: "+generosUsuario.get(position).getId()+",  Name: "+generosUsuario.get(position).getNombre();
                Toast.makeText(getApplicationContext(),mensaje,Toast.LENGTH_LONG).show();
            }
        });
    }
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_principal,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.MnuOpc1:
//                Toast.makeText(getApplicationContext(), "Config", Toast.LENGTH_SHORT).show();
                Intent myIntent = new Intent(this, GeneroActivity.class);
                startActivity(myIntent);
                return true;

            case R.id.MnuOpc2:
                Toast.makeText(getApplicationContext(), "Cambiar contraseña", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.MnuOpc3:
                Toast.makeText(getApplicationContext(), "Eliminado Usuario", Toast.LENGTH_SHORT).show();
                //Si ponemos Toast.LENGTH_Long no aparecera nunca el mensaje del menu
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void filtrarPreferenciasGenero(){
        for (int i = 0; i <preferencias.length; i++) {
            if(preferencias[i].getUserId()==MainActivity.idUser) {
                for (int j = 0; j < MainActivity.generosList.size(); j++) {
                    if (preferencias[i].getGeneroId() == MainActivity.generosList.get(j).getId())
                        generosUsuario.add(MainActivity.generosList.get(j));
                }
            }
        }
    }
}

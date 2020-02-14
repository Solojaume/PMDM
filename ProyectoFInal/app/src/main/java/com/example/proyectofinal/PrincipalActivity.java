package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class PrincipalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
    }
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_principal,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        String mensaje = "";
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
}

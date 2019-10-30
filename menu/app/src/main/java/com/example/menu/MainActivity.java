package com.example.menu;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_principal,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        String mensaje="";
        switch (item.getItemId()){
            case R.id.MnuOpc1:
                Toast.makeText(getApplicationContext(), "Opcion 1 pulsada!", Toast.LENGTH_LONG).show();
                return true;

            case R.id.MnuOpc2:
                Toast.makeText(getApplicationContext(), "Opcion 2 pulsada!", Toast.LENGTH_LONG).show();
                return true;

            case R.id.MnuOpc3:
                Toast.makeText(getApplicationContext(), "Opcion 3 pulsada!", Toast.LENGTH_LONG).show();
                return true;
                default:
                    return super.onOptionsItemSelected(item);
        }

    }

}

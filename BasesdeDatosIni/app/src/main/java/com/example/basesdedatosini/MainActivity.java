package com.example.basesdedatosini;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ClientesSQLiteHelper cliDBh = new ClientesSQLiteHelper(this, "DBClientes", null, 1);
        SQLiteDatabase bd = cliDBh.getWritableDatabase();

        if (bd != null) {
            for(int cont =1; cont<=3; cont++) {
                int cod = cont;
                String nombre = "Cli" + cont;
                String telefono = cont + "xxxxxx";
                bd.execSQL("INSERT INTO Clientes (codigo, nombre, telefono) " +
                        "VALUES (" + cod + ", '" + nombre + "', '" + telefono + "') ");
            }
            Toast toast1 = Toast.makeText(getApplicationContext(), cliDBh.getClients(bd), Toast.LENGTH_LONG);

            toast1.show();
            bd.execSQL("Delete FROM Clientes ");
        }
        bd.close();
    }

}
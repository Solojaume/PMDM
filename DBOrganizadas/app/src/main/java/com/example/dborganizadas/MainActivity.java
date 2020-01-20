package com.example.dborganizadas;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public DataBaseHelper cliBDh = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cliBDh = new DataBaseHelper(this);
        cliBDh.open(); //Abrimos la base de datos en modo escritura
        //En caso de abrir de forma correcta la base de datos
        if (cliBDh != null) {
            // Introducimos 3 clientes de ejemplo
            for (int cont = 1; cont <= 3; cont++) {
                //Creamos los datos
                int codigo = cont;
                String nombre = "cli" + cont;
                String telefono = cont + "XXXXXXX";
                //Introducimos los datos en la tabla Clientes
                cliBDh.insertItem(codigo, nombre, telefono);


                }
            Cursor c=cliBDh.getClients();
            String res="";
            if(c.moveToFirst()){
                do{
                    String nombreCli = c.getString(0);
                    String telefonoCli =c.getString(1);
                    res=res+"Nombre: "+nombreCli+ ", Telefono:"+ telefonoCli+"\n";

                } while (c.moveToNext());
                Toast toast1 = Toast.makeText(getApplicationContext(), res, Toast.LENGTH_LONG);

                toast1.show();
            }
        }

        cliBDh.close();
    }
}
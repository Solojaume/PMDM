package com.example.basesdedatosini;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ClientesSQLiteHelper extends SQLiteOpenHelper {
    String cadSQL = "CREATE TABLE Clientes (codigo INTEGER, nombre TEXT, telefono TEXT)";
    public ClientesSQLiteHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(cadSQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase bd, int oldVersion, int newVersion) {
        //Cuando se produce un cambio en la estructura se hace un DROP y se vuelve a crear con la nueva estructura la tabla
        bd.execSQL("DROP TABLE IF EXISTS Clientes");
        bd.execSQL(cadSQL);
    }
     public String getClients(SQLiteDatabase bd){
         String[] campos = new String[] {"nombre", "telefono"};
         Cursor c = bd.query("Clientes", campos, null,null,null,null, null, null);
         String res="";
         if(c.moveToFirst()){
             do{
                 String nombreCli = c.getString(0);
                 String telefonoCli =c.getString(1);
                 res=res+"Nombre: "+nombreCli+ ", Telefono:"+ telefonoCli+"\n";

             } while (c.moveToNext());

         }
         return res;
     }
}

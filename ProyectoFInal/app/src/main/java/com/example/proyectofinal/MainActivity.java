package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.SQLException;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.proyectofinal.controller.DataBaseHelper;
import com.example.proyectofinal.controller.GeneralConf;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private int mLastRowSelected = 0;
    public static DataBaseHelper mDbHelper = null;
    public static int idUser;
    public static EditText eUser,ePass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sesionIniciada();
        eUser=findViewById(R.id.editTextU);
        ePass=findViewById(R.id.editTextP);
        mDbHelper = new DataBaseHelper(this);
        try {
            fillData();
        } catch (SQLException e) {
            e.printStackTrace();
//            showMessage(R.string.dataError);
        }
//        registerForContextMenu(getListView());
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    public  void crearIniciarUsuario(View view){
        mDbHelper.open();
        if (mDbHelper.getUser(eUser.getText().toString())==null){

        }
    }

    public int sesionIniciada(){
        mDbHelper.open();
        Cursor itemCursor = mDbHelper.getUsuarios();
        ListEntry item = null;
        ArrayList<ListEntry> resultList = new ArrayList<ListEntry>();
        int cont=0;
        // se procesa el resultado
        while (itemCursor.moveToNext()) {
            int id = itemCursor.getInt(itemCursor.getColumnIndex(GeneralConf.U_ID));
            String pass = itemCursor.getString(itemCursor.getColumnIndex(GeneralConf.U_PASSWORD));
            String username = itemCursor.getString(itemCursor.getColumnIndex(GeneralConf.USERNAME));
            int iniciada = itemCursor.getInt(itemCursor.getColumnIndex(GeneralConf.U_INICIADO));
            if (iniciada==1){

                cont++;
                idUser=id;
            }


        }
        //cerramos la base de datos
        itemCursor.close();
        mDbHelper.close();
        if (cont==0){
            return 0;
        }
        return 1;
    }

    private void fillData() {
        // se abre la base de datos y se obtienen los elementos
        mDbHelper.open();
        Cursor itemCursor = mDbHelper.getUsuarios();
        ListEntry item = null;
        ArrayList<ListEntry> resultList = new ArrayList<ListEntry>();
        // se procesa el resultado
        while (itemCursor.moveToNext()) {
            int id = itemCursor.getInt(itemCursor.getColumnIndex(GeneralConf.U_ID));
            String pass = itemCursor.getString(itemCursor.getColumnIndex(GeneralConf.U_PASSWORD));
            String username = itemCursor.getString(itemCursor.getColumnIndex(GeneralConf.USERNAME));
            int iniciada = itemCursor.getInt(itemCursor.getColumnIndex(GeneralConf.U_INICIADO));
//            item = new ListEntry();
//            item.id = id;
//            item.task = task;
//            item.place = place;
//            item.importance = importance;
//            resultList.add(item);
        }
        //cerramos la base de datos
        itemCursor.close();
        mDbHelper.close();

    }
    private class ListEntry {
        int id;
        String task;
        String place;
        int importance;
    }
}

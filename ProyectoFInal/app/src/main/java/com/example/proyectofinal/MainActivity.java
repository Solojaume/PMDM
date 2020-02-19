package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.proyectofinal.controller.DataBaseHelper;
import com.example.proyectofinal.controller.GeneralConf;
import com.example.proyectofinal.model.Genero;
import com.example.proyectofinal.model.Preferencias;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private int mLastRowSelected = 0;
    public static DataBaseHelper mDbHelper = null;
    private Preferencias[] preferencias={new Preferencias(1,1,2),new Preferencias(2,2,1)};
    private Genero[] generos={new Genero(1,"Rock"), new Genero(2,"Balada"),new Genero(3,"Pop")};
    public static int idUser=1;
    Integer mRowId=null;
    TextView tError ;
    public static EditText eUser,ePass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eUser=findViewById(R.id.editTextU);
        ePass=findViewById(R.id.editTextP);
        mDbHelper = new DataBaseHelper(this);
        tError= findViewById(R.id.textViewError);
        mRowId = (savedInstanceState == null) ? null :
                (Integer) savedInstanceState.getSerializable(GeneralConf.U_ID);

//        sesionIniciada();
//        try {
//            fillData();
//        } catch (SQLException e) {
//            e.printStackTrace();
////            showMessage(R.string.dataError);
//        }
////        registerForContextMenu(getListView());
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    public void iniciarUsuario(View view){//onclick button
        mDbHelper.open();
        int resp=mDbHelper.userLogin(eUser.getText().toString(),ePass.getText().toString());
        if(resp>0){
            if (resp==2){//Todo correcto
                ePass.setText("");
                Intent intent = new Intent (this,PrincipalActivity.class);
                Bundle bundle= new Bundle();
                bundle.putSerializable("lG",generos);
                bundle.putSerializable("lP",preferencias);
                intent.putExtras(bundle);
                startActivity(intent);
                mDbHelper.close();
            }
            else {
                tError.setText("Contraseña incorreta");
            }
        }
        else
            tError.setText("Usuario no existe");
        mDbHelper.close();
    }

    public void  registrarUsuario(View view){
        mDbHelper.open();
        if(mDbHelper.userExist(eUser.getText().toString())==true){
            tError.setText("El usuario ya existe");

        }else{
            mDbHelper.insertUser(eUser.getText().toString(),ePass.getText().toString());
            Intent intent = new Intent (this,GeneroActivity.class);
            startActivity(intent);
        }
        mDbHelper.close();
    }

    public int sesionIniciada(){
        mDbHelper.open();
        Cursor userCursor = mDbHelper.getUsuarios();
        ListEntry item = null;
        ArrayList<ListEntry> resultList = new ArrayList<ListEntry>();
        int cont=0;
        // se procesa el resultado
        while (userCursor.moveToNext()) {
            int id = userCursor.getInt(userCursor.getColumnIndex(GeneralConf.U_ID));
            String pass = userCursor.getString(userCursor.getColumnIndex(GeneralConf.U_PASSWORD));
            String username = userCursor.getString(userCursor.getColumnIndex(GeneralConf.USERNAME));
            int iniciada = userCursor.getInt(userCursor.getColumnIndex(GeneralConf.U_INICIADO));
            if (iniciada==1){

                cont++;
                idUser=id;
            }


        }
        //cerramos la base de datos
        userCursor.close();
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

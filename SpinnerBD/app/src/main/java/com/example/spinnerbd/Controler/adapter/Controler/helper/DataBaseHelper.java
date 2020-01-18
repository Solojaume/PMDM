package com.example.spinnerbd.Controler.adapter.Controler.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper {
    private Context mCtx = null;
    private DataBaseHelperInternal mDbHelper = null;
    private SQLiteDatabase mDb = null;
    private static final String DATABASE_NAME = "DBClientes";
    private static final int DATABASE_VERSION = 3;
    private static final String DATABASE_TABLE_CLIENTES = "Clientes";
    public static final String EDAD = "codigo";
    public static final String NOMBRE = "nombre";
    public static final String APELLIDO = "apellido";
    private static final String DATABASE_CREATE_CLIENTES = "create table " + DATABASE_TABLE_CLIENTES + " (" + EDAD + " integer primary key ," + NOMBRE + " text not null," + "TELEFONO" + " text not null" + ")";

    public DataBaseHelper(Context ctx) {
        mCtx = ctx;
    }

    private static class DataBaseHelperInternal extends SQLiteOpenHelper {
        //constructor
        public DataBaseHelperInternal(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);    }
        @Override
        public void onCreate(SQLiteDatabase db) {
            createTables(db);
        }
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            deleteTables(db);
            createTables(db);
        }
        private void createTables(SQLiteDatabase db) {
            db.execSQL(DATABASE_CREATE_CLIENTES);
        }
        private void deleteTables(SQLiteDatabase db) {
            db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE_CLIENTES);
        }
    }
    public DataBaseHelper open()  {
        mDbHelper = new DataBaseHelperInternal(mCtx);
        mDb = mDbHelper.getWritableDatabase();
        return this;
    }
    public void close(){  mDbHelper.close();  }
    //crear elemento
    public long insertItem(int ed, String nom, String ap){
        ContentValues initialValues = new ContentValues();
        initialValues.put(EDAD, ed);
        initialValues.put(NOMBRE, nom);
        initialValues.put(APELLIDO, ap);
        return mDb.insert(DATABASE_TABLE_CLIENTES, null, initialValues);
    }
    public Cursor getClients(){
        String[] campos = new String[] {"edad","nombre", "apellidos"};
        Cursor c = mDb.query("Clientes", campos, null,null,null,null, null, null);
        return c;
    }
}
package com.example.proyectofinal.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.proyectofinal.MainActivity;
import com.example.proyectofinal.controller.GeneralConf;
import com.example.proyectofinal.model.Genero;

import java.util.ArrayList;
import java.util.List;

public class DataBaseHelper {
    private Context mCtx;
    private DataBaseHelperInternal mDbHelper = null;
    private SQLiteDatabase mDb = null;



    //constructor
    public DataBaseHelper(Context ctx) {
        this.mCtx = ctx;
    }
    private static class DataBaseHelperInternal extends SQLiteOpenHelper {
        public DataBaseHelperInternal(Context context) {
            super(context, GeneralConf.DATABASE_NAME, null, GeneralConf.DATABASE_VERSION);		}

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
            db.execSQL(GeneralConf.DATABASE_CREATE_USER);
            db.execSQL(GeneralConf.DATABASE_CREATE_GENERO);
            db.execSQL(GeneralConf.DATABASE_CREATE_PREFERENCIAS);
        }

        private void deleteTables(SQLiteDatabase db) {
            db.execSQL("DROP TABLE IF EXISTS " + GeneralConf.DATABASE_TABLE_USER);
            db.execSQL("DROP TABLE IF EXISTS " + GeneralConf.DATABASE_TABLE_GENERO);
            db.execSQL("DROP TABLE IF EXISTS " + GeneralConf.DATABASE_TABLE_PREFERENCIAS);
        }
    }
    public DataBaseHelper open()  {
        mDbHelper = new DataBaseHelperInternal(mCtx);
        mDb = mDbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        mDbHelper.close();
    }

    //obtener todos los usuarios
    public Cursor getUsuarios() {
        return mDb.query(GeneralConf.DATABASE_TABLE_USER, new String[] {GeneralConf.U_ID, GeneralConf.USERNAME, GeneralConf.U_PASSWORD,GeneralConf.U_INICIADO}, null, null, null, null,GeneralConf.USERNAME);
    }


    //crear User
    public long insertUser(String username, String password, int iniciado){
        ContentValues initialValues = new ContentValues();
        initialValues.put(GeneralConf.USERNAME, username);
        initialValues.put(GeneralConf.U_PASSWORD, password);
        initialValues.put(GeneralConf.U_INICIADO, iniciado);
        return mDb.insert(GeneralConf.DATABASE_TABLE_USER, null, initialValues);
    }

    public long insertUser( String username, String password){
        ContentValues initialValues = new ContentValues();
        initialValues.put(GeneralConf.USERNAME, username);
        initialValues.put(GeneralConf.U_PASSWORD, password);
//        initialValues.put(GeneralConf.U_INICIADO,1);
        asignarId(username);
        return mDb.insert(GeneralConf.DATABASE_TABLE_USER, null, initialValues);
    }

    //borrar usuario
    public int deleteUsuario(int mLastRowSelected) {
        return mDb.delete(GeneralConf.DATABASE_TABLE_USER, GeneralConf.U_ID + " = ?", new String[]{ Integer.toString(mLastRowSelected)});
    }

    //obtener usuario
    public Cursor getUser(String userName){
        return mDb.rawQuery(" select "+ GeneralConf.U_ID+","+ GeneralConf.USERNAME+","+ GeneralConf.U_PASSWORD+","+GeneralConf.U_INICIADO + " from " + GeneralConf.DATABASE_TABLE_USER  + " where " + GeneralConf.USERNAME + "= ?",new String[]{userName});
    }

    private boolean asignarId(String userName){
        try {
            Cursor cursor =getUser(userName);
            MainActivity.idUser= cursor.getColumnIndex(GeneralConf.U_ID);
            return true;
        }catch (SQLException E){
            MainActivity.idUser= 0;
            return false;
        }
    }

    //Logear usurio
    public int userLogin(String userName, String pas){
        try {
            Cursor cursor =getUser(userName);
            if(cursor.getCount() >0) {
                cursor = mDb.rawQuery(" select " + GeneralConf.U_ID + "," + GeneralConf.USERNAME + "," + GeneralConf.U_PASSWORD + "," + GeneralConf.U_INICIADO + " from " + GeneralConf.DATABASE_TABLE_USER + " where " + GeneralConf.USERNAME + "='"+userName +"' and "+ GeneralConf.U_PASSWORD+"='"+pas+"'",null);
                if(cursor.getCount() >0) {
                    MainActivity.idUser= cursor.getColumnIndex(GeneralConf.U_ID);
                    return 2;//Todo correcto
                }
                return 1;//Significa que el usuario existe pero la contraseña no es correcta
            }
        }catch (SQLException e){
            return 0;//no existe
        }
        return 0;
    }

    //comprobar si un usario existe
    public boolean userExist(String userName){
        try {
            Cursor cursor =getUser(userName);
            if(cursor.getCount() >0)
                return true;
        }catch (SQLException e) {
            return false;
        }
        return false;
    }

    //actualiza usuario
    public long updateItem(int id, String username, String password, int iniciado){
        ContentValues cv = new ContentValues();
        cv.put(GeneralConf.USERNAME, username);
        cv.put(GeneralConf.U_PASSWORD, password);
        cv.put(GeneralConf.U_INICIADO, iniciado);
        return mDb.update(GeneralConf.DATABASE_TABLE_USER, cv, GeneralConf.U_ID+ "=?", new String[]{Integer.toString(id)});
    }

    //Obtener generos
    private Cursor getGeneros() throws SQLException{
        Cursor c= mDb.query(GeneralConf.DATABASE_TABLE_GENERO, new String[] {GeneralConf.GENERO_ID, GeneralConf.G_NAME}, null, null, null, null,GeneralConf.GENERO_ID);
        return c;
    }

    //Obtener generos y los guarde en una lista
    public boolean cargarGeneros() {
        MainActivity.generosList.clear();
        try{
            Cursor c = this.getGeneros();
            while (c.moveToNext()){
                int id=c.getInt(c.getColumnIndex(GeneralConf.GENERO_ID));
                String name =c.getString(c.getColumnIndex(GeneralConf.G_NAME));
                MainActivity.generosList.add(new Genero(id,name));
            }
            return true;
        }catch (SQLException e){
            return false;
        }
    }

    //Insertar genero
    public long insertGenero(String name){
        ContentValues initialValues = new ContentValues();
        initialValues.put(GeneralConf.G_NAME,name);
        return mDb.insert(GeneralConf.DATABASE_TABLE_GENERO,null,initialValues);
    }

}

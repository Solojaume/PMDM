package com.example.proyectofinal.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.proyectofinal.controller.GeneralConf;
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
        }

        private void deleteTables(SQLiteDatabase db) {
            db.execSQL("DROP TABLE IF EXISTS " + GeneralConf.DATABASE_TABLE_USER);
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

    //obtener todos los elementos
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
        return mDb.insert(GeneralConf.DATABASE_TABLE_USER, null, initialValues);
    }

    //borrar usuario
    public int delete(int mLastRowSelected) {
        return mDb.delete(GeneralConf.DATABASE_TABLE_USER, GeneralConf.U_ID + "=?", new String[]{ Integer.toString(mLastRowSelected)});
    }

    //obtener usuario
    public Cursor getUser(int itemId){
        return mDb.rawQuery(" select "+ GeneralConf.U_ID+","+ GeneralConf.USERNAME+","+ GeneralConf.U_PASSWORD+","+GeneralConf.U_INICIADO + " from " + GeneralConf.DATABASE_TABLE_USER  + " where " + GeneralConf.U_ID + "= ?",new String[]{Integer.toString(itemId)});
    }
    public Cursor getUser(String userName){
        return mDb.rawQuery(" select "+ GeneralConf.U_ID+","+ GeneralConf.USERNAME+","+ GeneralConf.U_PASSWORD+","+GeneralConf.U_INICIADO + " from " + GeneralConf.DATABASE_TABLE_USER  + " where " + GeneralConf.USERNAME + "= ?",new String[]{userName});
    }

    //actualiza usuario
    public long updateItem(int id, String username, String password, int iniciado){
        ContentValues cv = new ContentValues();
        cv.put(GeneralConf.USERNAME, username);
        cv.put(GeneralConf.U_PASSWORD, password);
        cv.put(GeneralConf.U_INICIADO, iniciado);
        return mDb.update(GeneralConf.DATABASE_TABLE_USER, cv, GeneralConf.U_ID+ "=?", new String[]{Integer.toString(id)});
    }

    //count users


}

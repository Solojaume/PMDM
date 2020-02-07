package com.example.proyectofinal.controller;

public final class GeneralConf {
    protected static final String DATABASE_NAME = "DBFinal";
    protected static final int DATABASE_VERSION = 3;

    //Tabla Usuario
    public static final String DATABASE_TABLE_USER="user";
    public static final String U_ID ="id";
    public static final String USERNAME = "username";
    public static final String U_PASSWORD = "password";
    public static final String U_INICIADO = "iniciado";
    public static final String DATABASE_CREATE_USER=
            "create table "+DATABASE_TABLE_USER+" ("+U_ID+ "integer  primary key autoincrement,"+USERNAME+" text not null, "
            +U_PASSWORD+" text not null, "+U_INICIADO+ " integer )";
    //Tabla Genero
    public static final String DATABASE_TABLE_GENEROS="genero";
    public static final String GENERO_ID ="id";
    public static final String G_NAME  = "name";
    public static final String DATABASE_CREATE_GENERO=
            "create table "+DATABASE_TABLE_USER+" ("
                    +U_ID+ " integer primary key,"
                    +G_NAME+" text not null)";

     //Tabla Preferencia usuario
     public static final String DATABASE_TABLE_PREFERENCIAS="preferencias";
    public static final String PREFENCIAS_ID ="id";
    public static final String P_USER_ID = "user_id";
    public static final String P_GENERO_ID = "genero_id";
    public static final String DATABASE_CREATE_PREFERENCIAS=
            "create table "+DATABASE_TABLE_PREFERENCIAS+" (" +
                    ""+PREFENCIAS_ID+ "integer primary key autoincrement,"
                    +P_USER_ID+" integer not null, "
                    +P_GENERO_ID+" integer not null," +
                    "FOREIGN KEY ("+P_USER_ID+") REFERENCES "+DATABASE_TABLE_USER+" ("+U_ID+"),"+
                    "FOREIGN KEY ("+P_GENERO_ID+") REFERENCES "+DATABASE_TABLE_GENEROS+" ("+GENERO_ID+"))";





}


package com.example.proyectofinal.controller;

public class GeneralConf {
    protected static final String DATABASE_NAME = "DBFinal";
    protected static final int DATABASE_VERSION = 3;

    //Tabla Usuario
    protected static final String DATABASE_TABLE_USER="user";
    protected static final String U_ID ="id";
    protected static final String USERNAME = "username";
    protected static final String U_PASSWORD = "password";
    protected static final String U_INICIADO = "iniciado";
    protected static final String[] l={DATABASE_TABLE_USER,U_ID,USERNAME,U_PASSWORD,U_INICIADO};
    protected static final String DATABASE_CREATE_USER=
            "create table "+DATABASE_TABLE_USER+" ("+U_ID+ " integer primary key,"+USERNAME+" text not null, "
            +U_PASSWORD+" text not null, "+U_INICIADO+ " integer not null)";

     //Tabla Preferencia usuario
    protected static final String DATABASE_TABLE_PREFERENCIAS="preferencias";
    protected static final String PREFENCIAS_ID ="id";
    protected static final String P_USER_ID = "user_id";
    protected static final String P_GENERO_ID = "genero_id";


    //Tabla Genero
    protected static final String DATABASE_TABLE_GENEROS="genero";
    protected static final String GENERO_ID ="id";
    protected static final String G_NAME  = "name";


}


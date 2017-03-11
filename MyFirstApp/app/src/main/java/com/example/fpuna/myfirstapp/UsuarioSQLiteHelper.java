package com.example.fpuna.myfirstapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Hiroshi on 11/03/2017.
 */

public class UsuarioSQLiteHelper extends SQLiteOpenHelper {

    //Creamos una variable que contendra la sentencia SQL de creacion de la tabla
    String sql = "CREATE TABLE Usuario (Identificacion INTEGER, Nombres TEXT, Apellidos TEXT";


    public UsuarioSQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //ESte metodo se ejecuta automaticamente cuando la base de datos no existe
        //es decir, que la primera vez que se hace llamado a la clase, crea la BD
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Este metodo se ejecuta cuando se detecta que la version de la base de datos
        //cambio, por lo que se debe definir todos los procesos de migracion de la estructura
        //anterior a la estructura nueva. por simplicidad del ejemplo, lo que queremes es eliminar la
        //tabla existente y crearla neuvamente.


        db.execSQL("DROP TABLE IF EXISTS Usuario");
        db.execSQL(sql);
    }
}

package com.example.fpuna.myfirstapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * Created by Hiroshi on 12/03/2017.
 */

public class BaseHelper extends SQLiteOpenHelper {

    String tabla = "CREATE TABLE IF NOT EXISTS Usuario(Id INTEGER PRIMARY KEY AUTOINCREMENT, Name Text, Date Text, Sex Text)";

    public BaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(tabla);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}

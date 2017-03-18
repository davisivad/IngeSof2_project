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


    String tablaVacuna = "CREATE TABLE IF NOT EXISTS Vacuna(Id INTEGER PRIMARY KEY AUTOINCREMENT, Name Text, Edad Text, Dosis Text, Fecha Date, Lote Text, Responsable Text)";
    String tabla = "CREATE TABLE IF NOT EXISTS Usuario(Id INTEGER PRIMARY KEY AUTOINCREMENT, Name Text, Date Text, Sex Text, Vacuna tablaVacuna)";

    public BaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(tabla);
        db.execSQL("Insert into Vacuna values('Tuberculosis, 1, 10, 12/02/2001, asd, Doctor Fulano");
        db.execSQL("Insert into Vacuna values('RotaVirus,1, 10, 12/02/2001, asd, Doctor Fulano");
        db.execSQL("Insert into Vacuna values('PCV 10 Valente,1, 10, 12/02/2001, asd, Doctor Fulano");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}

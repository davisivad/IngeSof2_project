package com.example.fpuna.myfirstapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * Created by Hiroshi on 12/03/2017.
 */

class FeedReaderDbHelper extends SQLiteOpenHelper {

    public static abstract class DatosTabla implements BaseColumns {
        public static final String NOMBRE_TABLA = "Directorio";
        public static final String COLUMNA_ID = "id";
        public static final String COLUMNAS_NOMBRES = "nombres";
        public static final String COLUMNAS_SEXO = "sexo";

        private static final String TEXT_TYPE = " TEXT";
        private static final String COMMA_SEP = ",";
        private static final String CREAR_TABLA_1 =
                "CREATE TABLE " + DatosTabla.NOMBRE_TABLA + " (" +
                        DatosTabla._ID + " INTEGER PRIMARY KEY," +
                        DatosTabla.COLUMNAS_NOMBRES + TEXT_TYPE + COMMA_SEP +
                        DatosTabla.COLUMNAS_SEXO + TEXT_TYPE + " )";

        private static final String SQL_DELETE_ENTRIES =
                "DROP TABLE IF EXISTS " + DatosTabla.NOMBRE_TABLA;

    }

    public static final int DATA_VERSION = 1;
    public static final String DATABASE_NAME = "MiBaseDatos.db";

    public FeedReaderDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATA_VERSION);
    }
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DatosTabla.CREAR_TABLA_1);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DatosTabla.SQL_DELETE_ENTRIES);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}

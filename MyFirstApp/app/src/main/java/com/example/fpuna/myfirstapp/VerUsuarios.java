package com.example.fpuna.myfirstapp;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import static java.security.AccessController.getContext;

public class VerUsuarios extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_usuarios);

        FeedReaderDbHelper mDbHelper = new FeedReaderDbHelper(getContext());

        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        String[] projection = {
                FeedReaderDbHelper.DatosTabla._ID,
                FeedReaderDbHelper.DatosTabla.COLUMNAS_NOMBRES,
                FeedReaderDbHelper.DatosTabla.COLUMNAS_SEXO,
        };

        String selection = FeedReaderDbHelper.DatosTabla.COLUMNAS_NOMBRES + " = ?";
        String[] selectionArgs = {"My Title" };

        String sortOrder =
                FeedReaderDbHelper.DatosTabla._ID + "DESC";

        Cursor c = db.query(
                FeedReaderDbHelper.DatosTabla.NOMBRE_TABLA,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                sortOrder);


    }
}

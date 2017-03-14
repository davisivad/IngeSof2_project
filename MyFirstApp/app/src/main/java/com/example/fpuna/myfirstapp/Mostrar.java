package com.example.fpuna.myfirstapp;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Mostrar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar);
        CargarDatos();
    }

    public void CargarDatos()
    {
        BaseHelper baseHelper = new BaseHelper(this, "MiBasedeDatos", null, 1);
        SQLiteDatabase db = baseHelper.getReadableDatabase();
        if (db != null) {
            Cursor c = db.rawQuery("SELECT * FROM Usuario", null);
            int cantidad = c.getCount();
            int i = 0;
            String[] arreglo = new String[cantidad];
            if(c.moveToFirst()){
                do{
                    String linea = c.getInt(0)+" "+ c.getString(1)+" "+ c.getString(2)+" "+ c.getString(3);

                    arreglo[i] = linea;
                    i++;
                }while(c.moveToNext());
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, arreglo);
            ListView lista = (ListView)findViewById(R.id.lista);
            lista.setAdapter(adapter);
        }else{
            Toast.makeText(this, "NO FUNCIONA", Toast.LENGTH_SHORT).show();
        }

    }
}

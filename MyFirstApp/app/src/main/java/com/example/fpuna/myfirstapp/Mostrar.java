package com.example.fpuna.myfirstapp;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.Image;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Mostrar extends AppCompatActivity {

    Toolbar toolbar;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar);
        try{
            CargarDatos();
        }catch(Exception E){

        }
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
            Toast.makeText(this, "Entro", Toast.LENGTH_SHORT).show();
            lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(Mostrar.this, Detalles.class);
                  //intent.putExtra("Vacuna", listView.getItemAtPosition(position).toString());
                    startActivity(intent);
                }
            });
        }else{
            Toast.makeText(this, "NO FUNCIONA", Toast.LENGTH_SHORT).show();
        }

    }
}

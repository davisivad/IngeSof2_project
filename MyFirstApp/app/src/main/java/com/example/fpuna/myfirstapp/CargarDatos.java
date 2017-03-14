package com.example.fpuna.myfirstapp;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class CargarDatos extends Activity {

    EditText ET_Name, ET_Date, ET_Sex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cargar_datos);
        ET_Name = (EditText) findViewById(R.id.ET_Name);
        ET_Date = (EditText) findViewById(R.id.ET_Date);
        ET_Sex = (EditText) findViewById(R.id.ET_Sex);

    }

    public void GuardarDatos(View view) {
        String name = ET_Name.getText().toString();
        String date = ET_Date.getText().toString();
        String sex = ET_Sex.getText().toString();

        BaseHelper baseHelper = new BaseHelper(this, "MiBasedeDatos", null, 1);
        SQLiteDatabase db = baseHelper.getWritableDatabase();

        if (db != null) {
            try{
                ContentValues registronuevo = new ContentValues();
                registronuevo.put("Name", name);
                registronuevo.put("Date", date);
                registronuevo.put("Sex", sex);
                long i = db.insert("Usuario", null, registronuevo);
                if (i > 0) {
                    Toast.makeText(this, "Registro Insertado", Toast.LENGTH_SHORT).show();
                }
            }catch(Exception E){

            }

        }
    }

    public void MostrarDatos(View view){
        Intent intent = new Intent(CargarDatos.this, Mostrar.class);
        startActivity(intent);
    }
}


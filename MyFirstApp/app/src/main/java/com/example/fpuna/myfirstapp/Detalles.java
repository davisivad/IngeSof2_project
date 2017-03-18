package com.example.fpuna.myfirstapp;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class Detalles extends AppCompatActivity {

    EditText ET_Vacuna,ET_Dosis,ET_Fecha,ET_Lote,ET_Responsable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if(bundle != null){
            String cadena = (String) bundle.get("Vacuna");

        }
        ET_Vacuna = (EditText) findViewById(R.id.Vacuna);
        ET_Dosis = (EditText) findViewById(R.id.Dosis);
        ET_Fecha = (EditText) findViewById(R.id.Fecha);
        ET_Lote = (EditText) findViewById(R.id.Lote);
        ET_Responsable = (EditText) findViewById(R.id.Responsable);

    }

    public void GuardarDatos(View view) {
        String vacuna = ET_Vacuna.getText().toString();
        String dosis= ET_Dosis.getText().toString();
        String fecha = ET_Fecha.getText().toString();
        String lote = ET_Lote.getText().toString();
        String responsable = ET_Responsable.getText().toString();

        BaseHelper baseHelper = new BaseHelper(this, "MiBasedeDatos", null, 1);
        SQLiteDatabase db = baseHelper.getWritableDatabase();

        if (db != null) {
            try{
                ContentValues registronuevo = new ContentValues();
                registronuevo.put("Vacuna", vacuna);
                registronuevo.put("Dosis", dosis);
                registronuevo.put("Fecha", fecha);
                registronuevo.put("Lote", lote);
                registronuevo.put("Responsable", responsable);

                long i = db.insert("Vacuna", null, registronuevo);
                if (i > 0) {
                    Toast.makeText(this, "Registro Insertado", Toast.LENGTH_SHORT).show();
                }
            }catch(Exception E){

            }
        }
    }
}

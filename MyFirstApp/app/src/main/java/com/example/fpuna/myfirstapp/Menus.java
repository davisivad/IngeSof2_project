package com.example.fpuna.myfirstapp;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fpuna.myfirstapp.Entidades.Hijos;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hiroshi on 06/04/2017.
 */

public class Menus extends AppCompatActivity implements AdapterView.OnItemSelectedListener
{
    //Inicializacion de variables para elementos a utilizar
    protected Spinner hijosSpinner;
    protected TextView nombreapellido;
    protected TextView fecha_nacimiento;
    protected TextView sexo;
    protected SQLiteDatabase db;
    protected List<Hijos> hijosList = new ArrayList<Hijos>();
    protected List<String> nombreHijos = new ArrayList<String>();
    public static Hijos hijoseleccionado = new Hijos();


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        //Abre la base de datos
        db = openOrCreateDatabase("bdSqlite.db",MODE_PRIVATE,null);
        inicializarBd();
        if(db.isOpen()) cargarHijos();

        //Iniciliza el spinner
        hijosSpinner = (Spinner) findViewById(R.id.SpinnerHijos);
        hijosSpinner.setOnItemSelectedListener(this);
        ArrayAdapter<Hijos> adapter = new ArrayAdapter<Hijos>(this,android.R.layout.simple_spinner_item, hijosList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        hijosSpinner.setAdapter(adapter);

        nombreapellido = (TextView) findViewById(R.id.Nombreapellido);
        fecha_nacimiento = (TextView) findViewById(R.id.Fecha_nacimiento);
        sexo = (TextView) findViewById(R.id.Sexo);
    }

    private void cargarHijos() {

        //Recupera los datos en la bd y pone el cursor en la primera fila de resultados
        Cursor c = db.rawQuery("SELECT * FROM hijos",null);
        c.moveToFirst();
        Hijos hijos = new Hijos();
        hijos.setId(0);
        hijos.setNombreapellido("Seleccionar ");
        hijos.setFecha_nacimiento("un");
        hijos.setSexo(" Hij@");
        hijosList.add(0,hijos);

        //Guarda los clientes en una lista
        for(int i = 1; i <= c.getCount(); i++){

            hijos = new Hijos();
            hijos.setId(c.getInt(c.getColumnIndex("id_hijo")));
            hijos.setNombreapellido(c.getString(c.getColumnIndex("nombreapellido")));
            hijos.setFecha_nacimiento(c.getString(c.getColumnIndex("fecha_nacimiento")));
            hijos.setSexo(c.getString(c.getColumnIndex("sexo")));

            hijosList.add(i,hijos);
            c.moveToNext();
        }
        c.close();
    }

    private void inicializarBd() {

        try{
            db.execSQL("CREATE TABLE IF NOT EXISTS hijos (id_hijo INTEGER PRIMARY KEY," +
            "nombreapellido TEXT, fecha_nacimiento TEXT, sexo TEXT);");

            db.execSQL("CREATE TABLE IF NOT EXTIS vacuna (id_vacuna INTEGER PRIMARY KEY," +
            "nombre_vacuna TEXT NOT NULL, dosis INTEGER, edad INTEGER, FECHA TEXT, LOTE TEXT," +
            "nomresponsable TEXT, id_hijo INTEGER NOT NULL, aplicado TEXT, PRIMARY KEY(id_vacuna,id_hijo," +
            "FOREGEIN KEY(id_hijo) REFERENCES hijos(id_hijo));");

            Cursor hijos = db.rawQuery("SELECT count(*) from hijos",null);
            hijos.moveToFirst();
            int c = hijos.getInt(hijos.getColumnIndex("count(*)"));
            if(c >= 0 && c <=10 ){
                ContentValues valores = new ContentValues();
                valores.put("id_hijo","1");
                valores.put("nombreapellido","Juan Perez");
                valores.put("fecha_nacimiento","28/02/2017");
                valores.put("sexo","M");
                db.insert("hijos", null, valores);
                valores = new ContentValues();
                valores.put("id_hijo","2");
                valores.put("nombreapellido","Veronica Mitsui");
                valores.put("fecha_nacimiento","06/07/2017");
                valores.put("sexo","F");
                db.insert("hijos", null, valores);
            }
        }
        catch (Exception e){

        }
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        // Al seleccionar un elemento en el spinner
        String item = parent.getItemAtPosition(position).toString();

        // Muestra el elemento seleccionado y pone los datos de contacto en la pantalla
        if(position == 0){
            Toast.makeText(parent.getContext(), "Seleccione un hijo ", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(parent.getContext(), "Seleccionó: " + item, Toast.LENGTH_SHORT).show();
        }
        if(position == 0){
            nombreapellido.setVisibility(View.INVISIBLE);
            fecha_nacimiento.setVisibility(View.INVISIBLE);
            sexo.setVisibility(View.INVISIBLE);
        }
        else{
            nombreapellido.setVisibility(View.VISIBLE);
            fecha_nacimiento.setVisibility(View.VISIBLE);
            sexo.setVisibility(View.VISIBLE);
        }
        nombreapellido.setText(((hijosList.get(position).getNombreapellido() == null) ? ""
                : hijosList.get(position).getNombreapellido()));
        fecha_nacimiento.setText(((hijosList.get(position).getFecha_nacimiento() ==null) ? ""
                : hijosList.get(position).getFecha_nacimiento()));
        sexo.setText(((hijosList.get(position).getSexo() == null) ? ""
                : hijosList.get(position).getSexo()));

        // Extrae el cliente seleccionado a una variable para su uso en otras actividades
        hijoseleccionado = hijosList.get(position);

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
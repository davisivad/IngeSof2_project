package com.example.fpuna.myfirstapp;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CargarDatos extends AppCompatActivity implements View.OnClickListener{

    private Button add,finish;
    private EditText etId,etName,etDate,etSex;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cargar_datos);

        add = (Button)findViewById(R.id.button_add);
        add.setOnClickListener(this);
        finish = (Button)findViewById(R.id.button_finish);
        finish.setOnClickListener(this);


        etId = (EditText)findViewById(R.id.text_id);
        etName = (EditText)findViewById(R.id.text_name);
        etDate = (EditText)findViewById(R.id.text_date);
        etSex = (EditText)findViewById(R.id.text_sex);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_add:
                add();
                break;
            case R.id.button_finish:
                end();
                break;
        }
    }

    private void end() {
        finish();
    }

    private void add() {
        final FeedReaderDbHelper mDbHelper = new FeedReaderDbHelper(getApplicationContext());
        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put(FeedReaderDbHelper.FeedEntry.COLUMN_NAME,etName.getText().toString());
        valores.put(FeedReaderDbHelper.FeedEntry.COLUMN_DATE,etDate.getText().toString());
        valores.put(FeedReaderDbHelper.FeedEntry.COLUMN_SEX,etSex.getText().toString());

        Long IdGuardado = db.insert(FeedReaderDbHelper.FeedEntry.TABLE_NAME, null, valores);
        Toast.makeText(getApplicationContext(),"Se guardo el dato con ID" + IdGuardado, Toast.LENGTH_LONG).show();


    }
}

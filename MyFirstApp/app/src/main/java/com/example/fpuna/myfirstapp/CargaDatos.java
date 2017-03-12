package com.example.fpuna.myfirstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CargaDatos extends AppCompatActivity implements View.OnClickListener {

    private Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carga_datos);
        back = (Button)findViewById(R.id.button_end);
        back.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_end:
                button_back();
                break;
        }
    }

    private void button_back() {
        Intent back = new Intent(CargaDatos.this, MyFirstApp.class);
        startActivity(back);
    }
}

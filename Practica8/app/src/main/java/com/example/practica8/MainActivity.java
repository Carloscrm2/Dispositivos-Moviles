package com.example.practica8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn1 = (Button) findViewById(R.id.btn1);
        Button btn2 = (Button) findViewById(R.id.btn2);
        Button btn3 = (Button) findViewById(R.id.btn3);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn1:
                Intent intencion = new Intent(this, Portada.class);
                startActivity(intencion);
                Toast.makeText(this, "cambiando a la portada", Toast.LENGTH_LONG).show();
                break;
            case R.id.btn2:
                Intent intencion2 = new Intent(this, Calculadora.class);
                startActivity(intencion2);
                Toast.makeText(this, "cambiando a la calculadora", Toast.LENGTH_LONG).show();
                break;
            case R.id.btn3:
                Intent intentencion3 = new Intent(this, ConvertirGrados.class);
                startActivity(intentencion3);
                Toast.makeText(this, "cambiando a la converscion de grados", Toast.LENGTH_LONG).show();
                break;
        }
    }
}
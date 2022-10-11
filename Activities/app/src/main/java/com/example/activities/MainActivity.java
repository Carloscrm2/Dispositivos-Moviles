package com.example.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    String mensaje;
    double [] arreglodouble = new double[10];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bt1 = (Button) findViewById(R.id.btn1);
        bt1.setOnClickListener(this);
        mensaje = "Bienvenidos a la actividad 2";
        for (int i = 0; i < 10; i++){
            arreglodouble[i] = 8*(i+1);
        }
    }

    @Override
    public void onClick(View view) {
        Intent intencion = new Intent(this, MainActivity2.class);
        intencion.putExtra(MainActivity2.mensajeRecibido, mensaje);
        intencion.putExtra(MainActivity2.mensajeDoubleRecibido, arreglodouble);
        startActivity(intencion);
        Toast.makeText(this, "cambiando al Activity 2", Toast.LENGTH_LONG).show();

    }
}
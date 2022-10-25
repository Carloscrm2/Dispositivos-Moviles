package com.example.practica9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv1 = (TextView) findViewById(R.id.tv1);
        TextView tv2 = (TextView) findViewById(R.id.tv2);
        InputStream entradaDatos = getResources().openRawResource(R.raw.archivo);
        InputStreamReader leerDatos = new InputStreamReader(entradaDatos);
        BufferedReader buffer = new BufferedReader(leerDatos);

        String lineaDatos;
        while(true) {
            try {
                lineaDatos = buffer.readLine();
                if (lineaDatos == null)
                    break;
                tv2.append("\n" + lineaDatos);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
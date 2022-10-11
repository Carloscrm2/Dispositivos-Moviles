package com.example.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    public static final String mensajeRecibido = "mensaje";
    public static final String mensajeDoubleRecibido = "mensaje2";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView text1 = (TextView) findViewById(R.id.tx1);
        String mensaje = getIntent().getStringExtra("mensaje");
        text1.append("\n\n" + mensaje);

        double [] x = getIntent().getDoubleArrayExtra("mensaje2");
        for (int i = 0; i < 10; i++){
            text1.append("\n" + "8 x " + (i + 1) + "=" + x[i]);
        }

    }
}
package com.example.clase06sept;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    LinearLayout ly;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         ly = (LinearLayout)  findViewById(R.id.linear1);
         agregarTexto(ly, "UPITTA", 40, 255,0,0);
         // Referencias de variables a las vistas del activity main
        Button bt1 = (Button) findViewById(R.id.boton1);
        Button bt2 = (Button) findViewById(R.id.boton2);
        Button bt3 = (Button) findViewById(R.id.boton3);
        TextView textView1 = (TextView) findViewById(R.id.texto1);
        // Agregar funcionalidad al boton1 como clase anonima
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView1.setText("IPN");
                agregarTexto(ly, "telematica", 20, 0,255,0);
            }
        });

        bt1.setText("Enter");
        bt2.setText("Agregar");
        bt3.setText("Pausa");
    }

    public void agregarTexto(LinearLayout ly, String txt, int tam, int r, int g, int b){
        TextView tv1 = new TextView(this);
        tv1.setText(txt);
        tv1.setTextSize(tam);
        tv1.setTextColor(Color.rgb(r,g,b));
        ly.addView(tv1);

    }
}
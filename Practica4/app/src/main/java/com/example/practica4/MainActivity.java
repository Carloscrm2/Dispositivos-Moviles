package com.example.practica4;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Creamos el linealayout
        LinearLayout linearLayout1 = (LinearLayout)  findViewById(R.id.linearlayout1);
        linearLayout1.setOrientation(LinearLayout.VERTICAL);

        //Agregamos logo upiita
        ImageView imagen1 = new ImageView(this);
        imagen1.setImageResource(R.drawable.upiita);

        //Ajustamos las dimensiones del logo de upiita
        LinearLayout.LayoutParams parametros = new LinearLayout.LayoutParams(300,300);
        imagen1.setLayoutParams(parametros);
        parametros.gravity = Gravity.LEFT;

        linearLayout1.addView(imagen1);

    }
}
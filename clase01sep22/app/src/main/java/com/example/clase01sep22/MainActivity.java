package com.example.clase01sep22;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView texto1 = (TextView) findViewById(R.id.texto1);
        texto1.setText("Instituto politecnico nacional");
        texto1.setTextSize(20);
        texto1.setTextColor(Color.rgb(111, 29, 69));
        texto1.setGravity(Gravity.CENTER);

        // Agregar nueva vista TextView
        TextView texto2 = new TextView(this);
        texto2.setText("UPIITA");
        texto2.setTextSize(50);
        texto2.setTextColor(Color.BLACK);
        texto2.setGravity(Gravity.CENTER);

        // Agregamos el nuevo texto al LinearLayout
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linearlayout1);
        linearLayout.addView(texto2);

        //Agregar vista desde una función
        agregarTexto(linearLayout, "Nuevo texto desde una funcion");
        agregarTexto(linearLayout, "Segundo texto agregado");
        agregarTexto(linearLayout, "Tercer texto agregado", 40);

        //Agregar una imagen
        ImageView imagen1 = new ImageView(this);
        imagen1.setImageResource(R.drawable.upiita);
        linearLayout.addView(imagen1);
        imagen1.setScaleType(ImageView.ScaleType.FIT_CENTER);
        // Obtener ancho y alto de imagen
        int ancho = imagen1.getDrawable().getIntrinsicWidth();
        int alto = imagen1.getDrawable().getIntrinsicHeight();

        //Controlar dimensiones de una imagen
        LinearLayout.LayoutParams parametros = new LinearLayout.LayoutParams(600, 400);
        imagen1.setLayoutParams(parametros);
        parametros.gravity=Gravity.CENTER;

        //Agregar texto a un TextView ya existente
        texto2.append("\nProgramacion de dispositivos moviles");


    }

    public void agregarTexto(LinearLayout ly, String text){
        TextView txt1 = new TextView(this);
        txt1.setTextSize(25);
        txt1.setText(text);
        ly.addView(txt1);

    }

    public void agregarTexto(LinearLayout ly, String text,int size){
        TextView txt1 = new TextView(this);
        txt1.setTextSize(size);
        txt1.setText(text);
        ly.addView(txt1);

    }
}

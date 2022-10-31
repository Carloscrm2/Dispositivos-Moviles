package com.example.practica10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        vistaGraficos graficas = new vistaGraficos(this);
        setContentView(graficas);
    }

    public class vistaGraficos extends View{
        public vistaGraficos(Context context){ super(context);}
        @Override protected void onDraw(Canvas canvas){
            super.onDraw(canvas);

            int ancho = canvas.getWidth();
            int alto = canvas.getHeight();

            Paint pintura = new Paint();
            pintura.setColor(Color.rgb(76,175,86));
            canvas.drawPaint(pintura);
            RectF rectangulo = new RectF(ancho, alto,ancho,alto);
            canvas.drawRect(rectangulo, pintura);

            pintura.setColor(Color.WHITE);
            canvas.drawLine(50,95,50, (float)alto-70, pintura);
            canvas.drawLine(50,100,(float)ancho-73, 100, pintura);

            /*canvas.drawLine(50,300,50, (float)alto, pintura);
            canvas.drawLine(200,600,(float)ancho, 500, pintura);*/

            canvas.drawLine(500*2,95,500*2, (float)alto-70, pintura);

            canvas.drawLine(50,(float)alto-79,(float)ancho-73, (float)alto-79, pintura);

            //Area de meta superior
            RectF rectangulo2 = new RectF(400, 100, 700, 200);
            pintura.setStyle(Paint.Style.STROKE);
            canvas.drawRect(rectangulo2, pintura);
            //porteria superior
            RectF rectangulo3 = new RectF(460, 50, 650, 100);
            pintura.setStyle(Paint.Style.STROKE);
            canvas.drawRect(rectangulo3, pintura);
            //Area de meta inferior
            RectF rectangulo4 = new RectF(400, 1840, 700, 1740);
            pintura.setStyle(Paint.Style.STROKE);
            canvas.drawRect(rectangulo4, pintura);
            //porteria inferior
            RectF rectangulo5 = new RectF(460, 1840, 650, 1880);
            pintura.setStyle(Paint.Style.STROKE);
            canvas.drawRect(rectangulo5, pintura);

            RectF rectangulo6 = new RectF(300, 100, 800, 300);
            pintura.setStyle(Paint.Style.STROKE);
            canvas.drawRect(rectangulo6, pintura);

            RectF rectangulo7 = new RectF(300, 1840, 800, 1640);
            pintura.setStyle(Paint.Style.STROKE);
            canvas.drawRect(rectangulo7, pintura);

            canvas.drawCircle(ancho/2, alto/2, 200, pintura);
            canvas.drawLine(50,alto/2,(float)ancho-80, alto/2, pintura);

        }
    }
}
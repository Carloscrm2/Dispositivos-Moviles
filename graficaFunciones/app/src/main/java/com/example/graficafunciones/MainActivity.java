package com.example.graficafunciones;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        Graficas funciones = new Graficas(this);
        setContentView(funciones);
    }

    class Graficas extends View {
        public Graficas(Context context){
            super(context);
        }
        @Override
        protected void onDraw(Canvas canvas){
            super.onDraw(canvas);
            Paint pintura = new Paint();
            pintura.setColor(Color.YELLOW);
            canvas.drawPaint(pintura);

            int ancho = canvas.getWidth();
            int alto = canvas.getHeight();

            pintura.setColor(Color.BLACK);
            pintura.setTextSize(50);
            pintura.setStrokeWidth(5);
            canvas.drawText("ancho= " + ancho + " alto= " + alto, 50, 50, pintura);

            pintura.setStrokeWidth(3);
            for (int n = 0; n < ancho; n += 50){
                canvas.drawLine(0,n, ancho,n, pintura);
                canvas.drawText("" + n, ancho - 120, n, pintura);
            }

            canvas.translate(50,400);
            canvas.save();

            pintura.setColor(Color.RED);
            pintura.setStrokeWidth(8);
            canvas.drawLine(0,0,ancho-170,0, pintura);
            canvas.drawLine(0,-250,0,250, pintura);

            Path path1 = new Path();
            float x=0;
            float t = 0;
            float f = (float) 3 / (ancho-170);
            path1.moveTo(t,x);
            for ( t = 0; t < ancho-170; t++){
                x = (float) Math.sin(2*3.1416*f*t)*(-200f);
                path1.lineTo(t,x);
            }

            pintura.setColor(Color.BLUE);
            pintura.setStyle(Paint.Style.STROKE);
            canvas.drawPath(path1, pintura);

            float [] intervalos = {30, 20};
            DashPathEffect dash = new DashPathEffect(intervalos, 0);
            pintura.setPathEffect(dash);

            canvas.translate(0, 550);
            canvas.drawPath(path1, pintura);
            pintura.setColor(Color.RED);
            pintura.setPathEffect(null);
            canvas.drawLine(0,0,ancho-170,0, pintura);
            canvas.drawLine(0,-250,0,250, pintura);

            pintura.setPathEffect(dash);
            canvas.translate(0, 550);
            pintura.setColor(Color.BLUE);
            canvas.drawPath(path1, pintura);
            pintura.setColor(Color.RED);
            pintura.setPathEffect(null);
            canvas.drawLine(0,0,ancho-170,0, pintura);
            canvas.drawLine(0,-250,0,250, pintura);
        }
    }
}


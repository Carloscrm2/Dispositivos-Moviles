package com.example.canvas;

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
        setContentView(R.layout.activity_main);
        Vistagraficos graficas = new Vistagraficos(this);
        setContentView(graficas);

    }

    public class Vistagraficos extends View{
        public Vistagraficos(Context context) {
            super(context);
        }
        @Override protected void onDraw(Canvas canvas){
            super.onDraw(canvas);
            Paint pintura = new Paint();
            pintura.setColor(Color.MAGENTA);
            canvas.drawPaint(pintura);
            pintura.setColor(Color.BLACK);
            pintura.setTextSize(80);
            canvas.drawText("Hola Mundo", 80, 80, pintura);

            int ancho, alto;
            ancho = canvas.getWidth();
            alto = canvas.getHeight();
            canvas.drawText("ancho= " + ancho + " alto=" +alto, 80, 180, pintura);
            pintura.setColor(Color.YELLOW);
            pintura.setTextAlign(Paint.Align.CENTER);
            canvas.drawText("IPN", ancho/2, alto/2, pintura);
            //Dibujar una linea
            pintura.setColor(Color.WHITE);
            pintura.setStrokeWidth(10); //ancho de la linea
            canvas.drawLine(50,0,50, (float)alto, pintura);
            canvas.drawLine(50,100,(float)ancho, 100, pintura);
            pintura.setStyle(Paint.Style.STROKE); // Quitar el relleno del circulo
            canvas.drawCircle(ancho/2, alto/2, 300, pintura);

            //Dibujo de un rectangulo
            RectF rectangulo = new RectF(200, 100, 400, 500);
            canvas.drawRect(rectangulo, pintura);

            //Dibujar una trayectoria
            Path trazo = new Path();
            trazo.addCircle(ancho/2, alto/2, 300, Path.Direction.CCW);//CCW en contra de las manecillas
            pintura.setColor(Color.DKGRAY);
            canvas.drawTextOnPath("Instituto Politecnico Nacional", trazo, 400,80, pintura);

        }
    }
}
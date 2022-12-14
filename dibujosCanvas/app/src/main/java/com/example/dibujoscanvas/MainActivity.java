package com.example.dibujoscanvas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        Dibujos dibujo1 = new Dibujos(this);
        setContentView(dibujo1);
    }

    class Dibujos extends View {
        public Dibujos(Context context){
            super(context);
        }
        float x = 0;
        float y = 0;
        Path path = new Path();
        String accion = "";

        protected void onDraw(Canvas canvas){
            canvas.drawColor(Color.BLUE);
            Paint pintor = new Paint();
            pintor.setColor(Color.BLACK);
            pintor.setTextSize(80);
            pintor.setAntiAlias(true);

            canvas.save();
            canvas.drawText("Telematica", 100, 100, pintor);
            canvas.drawText("Telematica", 100, 100, pintor);
            canvas.restore();
            canvas.translate(100, 1000);
            canvas.drawText("Telematica", 100, 100, pintor);

            //canvas.restore();
            canvas.rotate(45);

            Rect bounds = new Rect();
            String texto = "Telematica";
            pintor.getTextBounds(texto, 0,texto.length(), bounds);
            float centerX = bounds.exactCenterX();
            float centerY = bounds.exactCenterY();
            canvas.save();
            canvas.rotate(-45, centerX, centerY);
            pintor.setStyle(Paint.Style.STROKE);
            pintor.setStrokeWidth(8);
            canvas.drawRect(bounds, pintor);
            canvas.drawText("Texto rotado", 0,0, pintor);
            canvas.restore();
            //Trazar lineas sobre una trayectoria (path)
            pintor.setColor(Color.WHITE);
            pintor.setStyle(Paint.Style.STROKE);
            path.moveTo(x, y);
            path.lineTo(1000,1000);
            canvas.translate(0,-1000);
            canvas.drawPath(path, pintor);
            path.lineTo(500, 1000);
            canvas.drawPath(path, pintor);

            if (accion=="down"){
                path.moveTo(x,y);
            }
            if (accion=="move"){
                path.lineTo(x,y);
            }
            canvas.drawPath(path,pintor);
        }

        public boolean onTouchEvent(MotionEvent evento){
            x=evento.getX();
            y=evento.getY();
            if (evento.getAction()==MotionEvent.ACTION_DOWN){
                accion="down";
            }

            if (evento.getAction()==MotionEvent.ACTION_MOVE){
                accion="move";
            }
            invalidate();
            return true;
        }
    }
}
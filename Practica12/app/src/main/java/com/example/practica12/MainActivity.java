package com.example.practica12;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        Vistagrafico mivista = new Vistagrafico(this);
        setContentView(mivista);
    }

    class Vistagrafico extends View {
        float x[] = {500, 530, 261, 787};
        float y[] = {809, 1263, 978, 946};
        float radio[] = {60, 100, 50, 80};
        int seleccion = -1;
        String txtEvento = "Evento";

        public Vistagrafico(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawColor(Color.YELLOW);
            Paint paint[] = new Paint[4];
            paint[0] = new Paint();
            paint[1] = new Paint();
            paint[2] = new Paint();
            paint[3] = new Paint();
            Paint paint2 = new Paint();
            paint[0].setColor(Color.BLUE);
            paint[1].setColor(Color.WHITE);
            paint[2].setColor(Color.GREEN);
            paint[3].setColor(Color.RED);
            for (int i = 0; i < 4; i++) {
                canvas.drawCircle(x[i], y[i], radio[i], paint[i]);
            }
            paint2.setColor(Color.BLACK);
            paint2.setTextSize(60);
            paint2.setStyle(Paint.Style.FILL_AND_STROKE);
            canvas.drawText("Selecciona un circulo", 100, 80, paint2);
            canvas.drawText("x0= " + x[0] + " y0= " +
                    y[0], 100, 150, paint2);
            canvas.drawText("x1= " + x[1] + " y1= " +
                    y[1], 100, 250, paint2);
            canvas.drawText("x2= " + x[2] + " y2= " +
                    y[2], 100, 350, paint2);
            canvas.drawText("x3= " + x[3] + " y3= " +
                    y[3], 100, 450, paint2);
            canvas.drawText(txtEvento, 100, 550, paint2);
        }

        @Override
        public boolean onTouchEvent(MotionEvent Evento) {
            float nx = Evento.getX();
            float ny = Evento.getY();
            float distancia;
            if (Evento.getAction() == MotionEvent.ACTION_DOWN) {
                seleccion = -1;
                for (int i = 0; i < 4; i++) {
                    distancia = (float) Math.sqrt((nx - x[i]) * (nx -
                            x[i]) + (ny - y[i]) * (ny - y[i]));
                    if (distancia < radio[i]) {
                        seleccion = i;
                        invalidate();
                    }
                }

            }
            if (Evento.getAction() == MotionEvent.ACTION_UP) {

            }
            if (Evento.getAction() == MotionEvent.ACTION_MOVE) {
                if (seleccion != -1) {
                    x[seleccion] = nx;
                    y[seleccion] = ny;
                    invalidate();
                }
            }
            return true;
        }
    }
}
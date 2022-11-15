package com.example.ontouch;

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
        setContentView(R.layout.activity_main);
        vistagrafico mivista = new vistagrafico(this);
        setContentView(mivista);
    }

    class vistagrafico extends View {
        float x[] = {300, 300};
        float y[] = {300,600};
        float radio[] = {60,100};
        String txtEvento = "Evento";
        public vistagrafico(Context context){
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas){
            canvas.drawColor(Color.YELLOW);
            Paint paint[] = new Paint[2];
            paint[0] = new Paint();
            paint[1] = new Paint();
            Paint paint2 = new Paint();
            paint[0].setColor(Color.BLUE);
            paint[1].setColor(Color.WHITE);
                for (int i=0; i<2;i++){
                    canvas.drawCircle(x[i],y[i],radio[i],paint[i]);
                }

            paint2.setColor(Color.BLACK);
            paint2.setTextSize(60);
            canvas.drawText("Mueve el ciruclo", 100, 80, paint2);
            canvas.drawText("x = " + x[0] + " y = " + y[0], 100, 150, paint2);
            canvas.drawText(txtEvento, 100, 230, paint2);
        }

        @Override
        public boolean onTouchEvent(MotionEvent Evento){
            float nx = Evento.getX();
            float ny = Evento.getY();
            float distancia = 0;
            for (int i=0; i<2;i++) {
                distancia = (float) Math.sqrt((nx - x[i]) * (nx - x[i]) + (ny - y[i]) * (ny - x[i]));
                if (distancia < radio[i]){
                    txtEvento = "Circulo seleccionado";
                    invalidate();
                }
            }
            if (Evento.getAction() == MotionEvent.ACTION_DOWN){
                /*x = Evento.getX();
                y = Evento.getY();
                txtEvento = "Action Down";
                // para que se apliquen los cambios es necesario usar invalidate()
                invalidate();*/
                /*if (distancia < radio[0]){
                    txtEvento = "Circulo seleccionado";
                    invalidate();

                }*/
            }

            if (Evento.getAction() == MotionEvent.ACTION_UP){
                /*x = Evento.getX();
                y = Evento.getY();
                txtEvento = "Action Up";
                // para que se apliquen los cambios es necesario usar invalidate()
                invalidate();*/
            }

            if (Evento.getAction() == MotionEvent.ACTION_MOVE){
                /*x = Evento.getX();
                y = Evento.getY();
                txtEvento = "Action Move";
                // para que se apliquen los cambios es necesario usar invalidate()
                invalidate();*/
                if (distancia<radio[0]){
                    txtEvento = "Moviendo circulo";
                    x[0] = nx;
                    y[0] = ny;
                    invalidate();
                }
            }



            return true;
        }
    }


}
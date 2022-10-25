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
        float x = 300;
        float y = 300;
        float radio = 60;
        String txtEvento = "Evento";
        public vistagrafico(Context context){
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas){
            canvas.drawColor(Color.YELLOW);
            Paint paint = new Paint();
            paint.setColor(Color.BLUE);
            canvas.drawCircle(x,y,radio,paint);
            paint.setColor(Color.BLACK);
            paint.setTextSize(60);
            canvas.drawText("Mueve el ciruclo", 100, 80, paint);
            canvas.drawText("x = " + x + " y = " + y, 100, 150, paint);
            canvas.drawText(txtEvento, 100, 230, paint);
        }

        @Override
        public boolean onTouchEvent(MotionEvent Evento){
            if (Evento.getAction() == MotionEvent.ACTION_DOWN){
                x = Evento.getX();
                y = Evento.getY();
                txtEvento = "Action Down";
                // para que se apliquen los cambios es necesario usar invalidate()
                invalidate();
            }

            if (Evento.getAction() == MotionEvent.ACTION_UP){
                x = Evento.getX();
                y = Evento.getY();
                txtEvento = "Action Up";
                // para que se apliquen los cambios es necesario usar invalidate()
                invalidate();
            }

            if (Evento.getAction() == MotionEvent.ACTION_MOVE){
                x = Evento.getX();
                y = Evento.getY();
                txtEvento = "Action Move";
                // para que se apliquen los cambios es necesario usar invalidate()
                invalidate();
            }



            return true;
        }
    }


}
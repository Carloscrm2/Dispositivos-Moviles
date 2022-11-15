package com.example.albumconcanvas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity {
int total_fotos = 5;
int[] id_fotos = {R.drawable.daltonico, R.drawable.ipn, R.drawable.tele, R.drawable.venom, R.drawable.trazos};
int i;
int anchofoto, altofoto;
int anchoCanvas, altoCanvas;
float relacionCanvas, relacionFoto;
int nuevox, nuevoy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        Vistafotos album = new Vistafotos(this);
        setContentView(album);

    }

    class Vistafotos extends View{
        Drawable foto;
        public Vistafotos(Context context){
            super(context);
        }
        @Override
        public void onDraw(Canvas canvas){
            Paint pintura = new Paint();
            pintura.setColor(Color.GREEN);
            canvas.drawPaint(pintura);
            foto = this.getResources().getDrawable(id_fotos[i]);
            anchofoto = foto.getIntrinsicWidth();
            altofoto = foto.getIntrinsicHeight();

            relacionCanvas = (float) altoCanvas/anchoCanvas;
            relacionFoto = (float) altofoto/anchofoto;

            if (relacionCanvas > relacionFoto){
                nuevox = anchoCanvas;
                nuevoy = (int) (nuevox*relacionFoto);
            }else{
                nuevoy = altoCanvas;
                nuevox = (int) (nuevoy/relacionFoto);

            }
            //Indica donde empieza el area de la foto
            foto.setBounds(0, 0, nuevox, nuevoy);
            foto.draw(canvas);
        }

        @Override
        public boolean onTouchEvent(MotionEvent evento){
            float X = evento.getX();
            float Y = evento.getY();

            if(evento.getAction()==MotionEvent.ACTION_DOWN){
                if (X >= nuevox/2 && X <= nuevox && Y <= nuevoy){
                    i++;
                    if (i==total_fotos)
                        i = 0;

                }else if (X >= nuevox/2 && X <= nuevox/2 && Y <= nuevoy){
                    i--;
                    if (i==-1)
                        i = total_fotos-1;
                }

            }
            invalidate();
            return true;
        }
    }
}
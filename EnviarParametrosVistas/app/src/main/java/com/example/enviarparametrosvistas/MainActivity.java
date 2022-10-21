package com.example.enviarparametrosvistas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout ly1 = (LinearLayout) findViewById(R.id.layout1);
        TextView tv1 = (TextView) findViewById(R.id.textView1);

        Rect rectangulo = new Rect();
        //Para obtener las dimensiones del la pantalla y lo guarda en rectangulo
        ly1.getWindowVisibleDisplayFrame(rectangulo);
        int ancho, alto, color; String texto;
        ancho = rectangulo.width();
        alto = rectangulo.height();
        tv1.append("\nancho = " + ancho + "\nalto = " + alto);
        tv1.append("\nUPIITA");
        color = Color.WHITE;
        texto = "IPN";
        VistaGrafico vista1 = new VistaGrafico(this, color,texto);
        LinearLayout.LayoutParams parametros = new LinearLayout.LayoutParams(1000, 500);
        vista1.setLayoutParams(parametros);
        ly1.addView(vista1);
    }

    public class VistaGrafico extends View {
        int color; String texto;
        int x, y;
        public VistaGrafico(Context context, int color, String texto) {
            super(context);
            this.color = color;
            this.texto = texto;
            this.x = 150;
            this.y = 100;
        }

        @Override protected void onDraw(Canvas canvas){
            super.onDraw(canvas);
            canvas.drawColor(Color.BLUE);
            Paint pintura = new Paint();
            pintura.setTextSize(80);
            pintura.setColor(color);
            x = 150;
            y = 150;
            if (texto.contains("\n")){
                String[] txt = texto.split("\n");
                for (String lineas:txt){
                    canvas.drawText(lineas, x, y, pintura);
                    y += pintura.getTextSize();
                }
            }else{
                canvas.drawText(texto, x, y, pintura);
            }

        }
    }
}
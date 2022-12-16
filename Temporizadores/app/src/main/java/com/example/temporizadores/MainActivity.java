package com.example.temporizadores;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    TextView texto1, texto2;
    int contador, contador1, contador2;
    Timer temporizador1, temporizador2;
    Tarea tarea1, tarea2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        texto1 = (TextView) findViewById(R.id.contador1);
        texto2 = (TextView) findViewById(R.id.contador2);

        tarea1 = new Tarea(texto1);
        tarea2 = new Tarea(texto2);
        temporizador1 = new Timer();
        temporizador2 = new Timer();
        contador1 = 0;
        contador2 = 0;
        temporizador1.scheduleAtFixedRate(tarea1, 0, 1000);
        temporizador2.scheduleAtFixedRate(tarea2, 5000, 500);


    }

    class Tarea extends TimerTask{
        TextView tv;
        public Tarea(TextView tv){
            this.tv = tv;
        }
        @Override
        public void run() {
            Programa  miPrograma = new Programa(tv);
            tv.post(miPrograma);
        }
    }

    class Programa implements Runnable{
        TextView tv;

        public Programa(TextView textview){
            this.tv = textview;
        }
        @Override
        public void run() {
            if (tv.getId() == R.id.contador1){
                contador1+=1;
                contador = contador1;
            }
            if (tv.getId() == R.id.contador2){
                contador2+=1;
                contador = contador2;
            }
            tv.setText("Contador = " + contador);
            if (contador1 == 20){
                temporizador1.cancel();
            }
            if (contador2 == 50){
                temporizador2.cancel();
            }
        }
    }
}
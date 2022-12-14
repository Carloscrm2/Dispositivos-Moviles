package com.example.hilos1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Controlador control = new Controlador();
    TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = (TextView) findViewById(R.id.texto1);
        Hilo hilo1 = new Hilo(10,1000);
        Hilo hilo2 = new Hilo(5, 2000);
        hilo1.setName("Hilo prinicipal");
        hilo2.setName("Hilo secundario");
        hilo1.start();
        hilo2.start();

    }

    class Controlador extends Handler{
        @Override
        public void handleMessage(Message msg){
            int entero;
            String nombreHilo;
            entero = msg.getData().getInt("Contador");
            nombreHilo = msg.getData().getString("nombre");
            tv1.append("\n" + entero + " Nombre = " + nombreHilo);
        }
    }

    class Hilo extends Thread{
        int maximo, tiempo;
        Hilo(int n , int t){
            maximo = n;
            tiempo = t;
        }
        @Override
        public void run(){
            for (int  i = 1; i <= maximo; i++){
                try{
                    Thread.sleep(tiempo);
                }catch (InterruptedException e){
                    System.out.println(e);
                }

                Message msg1 = new Message();
                Bundle b = new Bundle();
                b.putInt("Contador", i);
                b.putString("nombre", getName());
                msg1.setData(b);
                control.sendMessage(msg1);

            }
        }
    }
}
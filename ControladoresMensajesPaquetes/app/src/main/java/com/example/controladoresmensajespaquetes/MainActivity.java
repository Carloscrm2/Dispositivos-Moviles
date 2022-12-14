package com.example.controladoresmensajespaquetes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tv1;
    Button btn;
    Controlador controlador1 = new Controlador();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = (TextView) findViewById(R.id.texto1);
        btn = (Button) findViewById(R.id.btn1);
        btn.setOnClickListener(this);

        //Crear un mensaje
        Message msg = new Message();
        //Crear un paquete (Bundle)
        Bundle bundle = new Bundle();

        bundle.putInt("MiEntero", 5);
        bundle.putString("MiCadena", "Hola");
        bundle.putChar("MiCaracter", 'C');

        //Insertar paquete al mensaje
        msg.setData(bundle);
        //Enviamos el mensaje al controlador
        controlador1.sendMessage(msg);
    }

    @Override
    public void onClick(View view) {
        tv1.append("\nEntero = " + controlador1.entero);
        tv1.append("\nCadena = " + controlador1.cadena);
        tv1.append("\nCaracter = " + controlador1.cadena);
    }

    class Controlador extends Handler{
        public int entero;
        public String cadena;
        public char caraceter;

        @Override
        public void handleMessage(Message mensaje){
            entero = mensaje.getData().getInt("MiEntero");
            cadena = mensaje.getData().getString("MiCadena");
            caraceter = mensaje.getData().getChar("MiCaracter");
        }
    }
}
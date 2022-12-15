package com.example.dialogos;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.service.controls.actions.ControlAction;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button boton1, boton2;
    TextView tv1;
    ProgressDialog progreso;
    int maximo = 100;
    int delay = 100;
    int estilo = 1;
    Controlador control = new Controlador();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boton1 = (Button) findViewById(R.id.btn1);
        boton2 = (Button) findViewById(R.id.btn2);
        tv1 = (TextView) findViewById(R.id.texto1);

        boton1.setOnClickListener(this);
        boton2.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn1:
                showDialog(0);
                break;
            case R.id.btn2:
                AlertDialog.Builder constructorDia1 = new AlertDialog.Builder(MainActivity.this);
                constructorDia1.setIcon(R.mipmap.ic_launcher);
                constructorDia1.setTitle("Titulo del Dialgo");
                constructorDia1.setMessage("Mensaje de alerta");

                constructorDia1.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "Presionaste el boton dialogos", Toast.LENGTH_LONG).show();
                    }
                });
                constructorDia1.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "Presioanste Cancelar", Toast.LENGTH_LONG).show();
                    }
                });

                AlertDialog alerta = constructorDia1.create();
                alerta.show();
                break;
        }


    }

    @Override
    public Dialog onCreateDialog(int id){
        progreso = new ProgressDialog(this);
        progreso.setProgressStyle(estilo);
        progreso.setMessage("");
        return progreso;
    }

    @Override
    public void onPrepareDialog(int id, Dialog dialogo){
        progreso = (ProgressDialog) dialogo;
        progreso.setProgressStyle(estilo);
        progreso.setMax(maximo);
        progreso.setProgress(0);
        progreso.setMessage("Ejecutar HIlo en segundo plano...");

        Hilo hilo = new Hilo();
        hilo.start();
    }

    class Controlador extends Handler {
        @Override
        public void handleMessage(Message msg){
            int total = msg.getData().getInt("total");
            tv1.setText("Total =" + total);
            progreso.setProgress(total);

            if(total == maximo){
                dismissDialog(0);
            }

        }
    }

    class Hilo extends Thread{
        @Override
        public void run(){
            for (int i=0; i <= maximo; i++){
                try{
                    Thread.sleep(delay);
                }catch (Exception e){
                    System.out.println(e);
                }
                Message msg = new Message();
                Bundle bundle = new Bundle();
                bundle.putInt("total",i);
                msg.setData(bundle);
                control.sendMessage(msg);
            }
        }
    }
}
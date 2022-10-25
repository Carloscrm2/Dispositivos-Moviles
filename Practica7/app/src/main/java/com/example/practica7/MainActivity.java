package com.example.practica7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    TextView txt6, txt7, txt8, txt9, txt10;
    EditText edtx1, edtx2, edtx3, edtx4, edtx5;

    SharedPreferences misDatos;
    String nombre, apellido, edad, grupo, carrera;

    CheckBox cbox1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt6 = (TextView) findViewById(R.id.txt6);
        txt7 = (TextView) findViewById(R.id.txt7);
        txt8 = (TextView) findViewById(R.id.txt8);
        txt9 = (TextView) findViewById(R.id.txt9);
        txt10 = (TextView) findViewById(R.id.txt10);

        edtx1 = (EditText) findViewById(R.id.edtx1);
        edtx2 = (EditText) findViewById(R.id.edtx2);
        edtx3 = (EditText) findViewById(R.id.edtx3);
        edtx4 = (EditText) findViewById(R.id.edtx4);
        edtx5 = (EditText) findViewById(R.id.edtx5);

        clasepropiaOnkeyListener miListener = new clasepropiaOnkeyListener();
        edtx1.setOnKeyListener(miListener);
        edtx2.setOnKeyListener(miListener);
        edtx3.setOnKeyListener(miListener);
        edtx4.setOnKeyListener(miListener);
        edtx5.setOnKeyListener(miListener);

        cbox1 = (CheckBox) findViewById(R.id.chb1);

        misDatos = getSharedPreferences("preferencias", 0);
        nombre = misDatos.getString("name", "No hay nombre");
        apellido = misDatos.getString("last_name", "No hay apellido");
        edad = misDatos.getString("age", "No hay edad");
        grupo = misDatos.getString("group", "No hay grupo");
        carrera = misDatos.getString("carrier", "No hay carrera");
        edtx1.setText(nombre);
        edtx2.setText(apellido);
        edtx3.setText(edad);
        edtx4.setText(grupo);
    }
    @Override
    protected void onStart(){
        super.onStart();
        Toast.makeText(getApplicationContext(),"onStart",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onResume(){
        super.onResume();
        Toast.makeText(getApplicationContext(),"onResume",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPause(){
        super.onPause();
        Toast.makeText(getApplicationContext(),"onPause",Toast.LENGTH_LONG).show();
        //Creamos un editor para poder guardar en el archivo los datos ingresados por el usuario
        SharedPreferences.Editor miEditor = misDatos.edit();
        nombre  = edtx1.getText().toString();
        apellido = edtx2.getText().toString();
        edad = edtx3.getText().toString();
        grupo = edtx4.getText().toString();
        carrera = edtx5.getText().toString();
        // Guardamos los datos ingresados en los EditText en el editor
        miEditor.putString("name", nombre);
        miEditor.putString("last_name", apellido);
        miEditor.putString("age", edad);
        miEditor.putString("group", grupo);
        miEditor.putString("carrier", carrera);
        // Guardamos el archivo
        miEditor.commit();
    }

    @Override
    protected void onStop(){
        super.onStop();
        Toast.makeText(getApplicationContext(),"onStop",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        //Borramos los datos del archivo
        if (cbox1.isChecked()==true){
            misDatos.edit().clear().commit();
            Toast.makeText(getApplicationContext(),"onDestroy",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Toast.makeText(getApplicationContext(),"onRestart",Toast.LENGTH_LONG).show();
    }

    class clasepropiaOnkeyListener implements View.OnKeyListener{

        @Override
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (keyEvent.getAction()==KeyEvent.ACTION_DOWN && i==KeyEvent.KEYCODE_ENTER){
                switch (view.getId()){
                    case R.id.edtx1:
                        txt6.setText("Tu nombre es: " + edtx1.getText().toString());
                        break;
                    case R.id.edtx2:
                        txt7.setText("Tu apellido es: " + edtx2.getText().toString());
                        break;
                    case R.id.edtx3:
                        txt8.setText("Tu edad es: " + edtx3.getText().toString());
                        break;
                    case R.id.edtx4:
                        txt9.setText("Tu grupo es:c" + edtx4.getText().toString());
                        break;
                    case R.id.edtx5:
                        txt10.setText("Tu carreras es: " + edtx5.getText().toString());
                }
                return true;
            }
            return false;
        }
    }
}
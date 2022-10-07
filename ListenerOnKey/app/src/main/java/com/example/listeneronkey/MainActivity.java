package com.example.listeneronkey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputType;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tx1, tx2, tx3, tx4;
    EditText edtx1, edtx2;

    SharedPreferences misDatos;
    String nombre, apellido;

    CheckBox cbox1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(getApplicationContext(),"onCreate",Toast.LENGTH_LONG).show();
        setContentView(R.layout.activity_main);
        tx1 = (TextView) findViewById(R.id.txt1);
        tx2 = (TextView) findViewById(R.id.txt2);
        tx3 = (TextView) findViewById(R.id.txt3);
        tx4 = (TextView) findViewById(R.id.txt4);
        edtx1 = (EditText) findViewById(R.id.edtx1);
        edtx2 = (EditText) findViewById(R.id.edtx2);
        cbox1 = (CheckBox) findViewById(R.id.cbox1);
        Button button1 = (Button) findViewById(R.id.btn1);
        button1.setOnClickListener(this);
        clasepropiaOnKeyListener miListener = new clasepropiaOnKeyListener();
        edtx2.setOnKeyListener(miListener);
        edtx1.setOnKeyListener(miListener);
        //Poner teclado numerico
        //edtx1.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_VARIATION_PASSWORD);

        //getSharedPreferences("nombre archivo", modo: protegido(0))
        misDatos = getSharedPreferences("preferencias", 0);
        // El segundo parametro es por si no encuentra nada en el archivo
        // El primer argumento es el nombre de la etiqueta
        nombre = misDatos.getString("name", "No hay nombre");
        apellido = misDatos.getString("last_name", "No hay apellido");
        edtx1.setText(nombre);
        edtx2.setText(apellido);


       /*edtx2.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
            //Verificar si la tecla esta presionada y que sea la tecla ENTER
                if(keyEvent.getAction()==KeyEvent.ACTION_DOWN && i==KeyEvent.KEYCODE_ENTER){
                    tx3.setText("Tu nombre es: " + edtx1.getText().toString());
                    tx4.setText("Tu apellido es: " + edtx2.getText().toString());
                    //Mensaje emergente
                    Toast.makeText(getApplicationContext(),"tecla = " + i,Toast.LENGTH_LONG).show();
                    return true;
                }
                return false;
            }
        });*/
    }
    //Ciclos de vida de una aplicacion
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

    //Cuando la aplicacion esta en segundo plano
    @Override
    protected void onPause(){
        super.onPause();
        Toast.makeText(getApplicationContext(),"onPause",Toast.LENGTH_LONG).show();
        //Creamos un editor para poder guardar en el archivo los datos ingresados por el usuario
        SharedPreferences.Editor miEditor = misDatos.edit();
        nombre  = edtx1.getText().toString();
        apellido = edtx2.getText().toString();
        // Guardamos los datos ingresados en los EditText en el editor
        miEditor.putString("name", nombre);
        miEditor.putString("last_name", apellido);
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


    @Override
    public void onClick(View view) {
        tx3.setText("Tu nombre es: " + edtx1.getText().toString());
        tx4.setText("Tu apellido es: " + edtx2.getText().toString());
        Toast.makeText(getApplicationContext(),"Desde el Botón",Toast.LENGTH_LONG).show();
    }
    class clasepropiaOnKeyListener implements View.OnKeyListener{
        @Override
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if(keyEvent.getAction()==KeyEvent.ACTION_DOWN && i==KeyEvent.KEYCODE_ENTER){
                switch(view.getId()){
                    case R.id.edtx1:
                        tx3.setText("Tu nombre es: " + edtx1.getText().toString());
                        break;
                    case R.id.edtx2:
                        tx4.setText("Tu apellido es: " + edtx2.getText().toString());
                        break;
                }
                //Mensaje emergente
                Toast.makeText(getApplicationContext(),"tecla = " + i,Toast.LENGTH_LONG).show();
                return true;
            }
            return false;
        }
    }


}
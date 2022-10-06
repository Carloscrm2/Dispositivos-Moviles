package com.example.listeneronkey;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tx1, tx2, tx3, tx4;
    EditText edtx1, edtx2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tx1 = (TextView) findViewById(R.id.txt1);
        tx2 = (TextView) findViewById(R.id.txt2);
        tx3 = (TextView) findViewById(R.id.txt3);
        tx4 = (TextView) findViewById(R.id.txt4);
        edtx1 = (EditText) findViewById(R.id.edtx1);
        edtx2 = (EditText) findViewById(R.id.edtx2);
        Button button1 = (Button) findViewById(R.id.btn1);
        button1.setOnClickListener(this);
        clasepropiaOnKeyListener miListener = new clasepropiaOnKeyListener();
        edtx2.setOnKeyListener(miListener);
        edtx1.setOnKeyListener(miListener);
        //Poner teclado numerico
        edtx1.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_VARIATION_PASSWORD);

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
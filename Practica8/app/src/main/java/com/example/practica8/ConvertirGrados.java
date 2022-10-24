package com.example.practica8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ConvertirGrados extends AppCompatActivity{
    EditText edtx1, edtx2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convertir_grados);

        edtx1 = (EditText) findViewById(R.id.edtx1);
        edtx2 = (EditText) findViewById(R.id.edtx2);

        clasepropiaOnkeyListener miListener = new clasepropiaOnkeyListener();
        edtx1.setOnKeyListener(miListener);
        edtx2.setOnKeyListener(miListener);
    }

    class clasepropiaOnkeyListener implements View.OnKeyListener{
        @Override
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (keyEvent.getAction()==KeyEvent.ACTION_DOWN && i==KeyEvent.KEYCODE_ENTER){
                switch (view.getId()){
                    case R.id.edtx1:
                        float Celcius = Float.parseFloat(edtx1.getText().toString());
                        float Farenheit = (float)(Celcius * 1.8 + 32);
                        String Faren = Float.toString(Farenheit);
                        edtx2.setText(Faren);
                        break;
                    case R.id.edtx2:
                        Farenheit = Float.parseFloat(edtx2.getText().toString());
                        Celcius = (float) ((Farenheit - 32) / 1.8);
                        String Celc = Float.toString(Celcius);
                        edtx1.setText(Celc);
                        break;
                }
                return true;
            }
            return  false;
        }


    }

}


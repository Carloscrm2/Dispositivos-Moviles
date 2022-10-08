package com.example.practica6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    TextView txt6, txt7, txt8, txt9, txt10;
    EditText edtx1, edtx2, edtx3, edtx4, edtx5;

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
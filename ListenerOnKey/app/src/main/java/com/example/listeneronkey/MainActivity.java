package com.example.listeneronkey;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView txt1, txt2, txt3, txt4;
    EditText edtx1, edtx2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView txt1 = (TextView) findViewById(R.id.txt1);
        TextView txt2 = (TextView) findViewById(R.id.txt2);
        TextView txt3 = (TextView) findViewById(R.id.txt3);
        TextView txt4 = (TextView) findViewById(R.id.txt4);
        EditText edtx1 = (EditText) findViewById(R.id.edtx1);
        EditText edtx2 = (EditText) findViewById(R.id.edtx2);
        Button button1 = (Button) findViewById(R.id.btn1);

        button1.setOnClickListener(this);

        edtx2.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                //Verificar si la tecla esta presionada y que sea la tecla ENTER
                if (keyEvent.getAction()==KeyEvent.ACTION_DOWN && i==KeyEvent.KEYCODE_ENTER){
                    txt3.setText("Tu nombre es: " + edtx1.getText().toString());
                    txt4.setText("Tu apellido es: " + edtx2.getText().toString());
                    //Mensaje emergente
                    Toast.makeText(getApplicationContext(), "Desde el OnKey", Toast.LENGTH_LONG).show();
                    return true;
                }
                return false;
            }
        });
    }

    @Override
    public void onClick(View view) {
        txt3.setText("Tu nombre es: " + edtx1.getText().toString());
        txt4.setText("Tu apellido es: " + edtx2.getText().toString());
    }
}
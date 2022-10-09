package com.example.practica5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableLayout;

public class MainActivity extends AppCompatActivity {
    TableLayout tl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tl = (TableLayout) findViewById(R.id.tl);
        Button btn1 = (Button) findViewById(R.id.btn1);  //MC
        Button btn2 = (Button) findViewById(R.id.btn2); //MR
        Button btn3 = (Button) findViewById(R.id.btn3); //M+
        Button btn4 = (Button) findViewById(R.id.btn4); //M-
        Button btn5 = (Button) findViewById(R.id.btn5); //MS
        Button btn6 = (Button) findViewById(R.id.btn6); //M
        Button btn7 = (Button) findViewById(R.id.btn7); //%
        Button btn8 = (Button) findViewById(R.id.btn8); //CE
        Button btn9 = (Button) findViewById(R.id.btn9); //C
        Button btn10 = (Button) findViewById(R.id.btn10); //DEL
        Button btn11 = (Button) findViewById(R.id.btn11); //1/X
        Button btn12 = (Button) findViewById(R.id.btn12); //X^2
        Button btn13 = (Button) findViewById(R.id.btn13); //SQRT(X)
        Button btn14 = (Button) findViewById(R.id.btn14); // /
        Button btn15 = (Button) findViewById(R.id.btn15); // 7
        Button btn16 = (Button) findViewById(R.id.btn16); // 8
        Button btn17 = (Button) findViewById(R.id.btn17); // 9
        Button btn18 = (Button) findViewById(R.id.btn18); // x
        Button btn19 = (Button) findViewById(R.id.btn19); // 4
        Button btn20 = (Button) findViewById(R.id.btn20); // 5
        Button btn21 = (Button) findViewById(R.id.btn21); // 6
        Button btn22 = (Button) findViewById(R.id.btn22); // -
        Button btn23 = (Button) findViewById(R.id.btn23); // 1
        Button btn24 = (Button) findViewById(R.id.btn24); // 2
        Button btn25 = (Button) findViewById(R.id.btn25); // 3
        Button btn26 = (Button) findViewById(R.id.btn26); // +
        Button btn27 = (Button) findViewById(R.id.btn27); // +/-
        Button btn28 = (Button) findViewById(R.id.btn28); // 0
        Button btn29 = (Button) findViewById(R.id.btn29); // ,
        Button btn30 = (Button) findViewById(R.id.btn30); // =


    }
}
package com.example.practica5;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    TableLayout tl;
    TextView pantalla;

    String aux;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tl = (TableLayout) findViewById(R.id.tl);
        pantalla = (TextView) findViewById(R.id.pantalla);

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
        Button btn14 = (Button) findViewById(R.id.btn14); // / ÷
        Button btn15 = (Button) findViewById(R.id.btn15); // 7
        Button btn16 = (Button) findViewById(R.id.btn16); // 8
        Button btn17 = (Button) findViewById(R.id.btn17); // 9
        Button btn18 = (Button) findViewById(R.id.btn18); // x (multi)
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

        btn15.setOnClickListener(this); // 7
        btn16.setOnClickListener(this); // 8
        btn17.setOnClickListener(this); // 9
        btn19.setOnClickListener(this); // 4
        btn20.setOnClickListener(this); // 5
        btn21.setOnClickListener(this); // 6
        btn23.setOnClickListener(this); // 1
        btn24.setOnClickListener(this); // 2
        btn25.setOnClickListener(this); // 3
        btn28.setOnClickListener(this); // 0

        btn26.setOnClickListener(this); // +
        btn22.setOnClickListener(this); // -
        btn18.setOnClickListener(this); // *
        btn14.setOnClickListener(this); // ÷
        btn13.setOnClickListener(this); // SQRT(X)
        btn12.setOnClickListener(this); // ^2
        btn11.setOnClickListener(this); // 1/X
        btn8.setOnClickListener(this); // CE
        btn9.setOnClickListener(this); // C
        btn10.setOnClickListener(this); // DEL
        btn30.setOnClickListener(this); // =

    }

    @Override
    public void onClick(View view){
        int id_vista = view.getId();
        switch (id_vista){
            case R.id.btn15: // 7
                agregarTexto("7");
                break;
            case R.id.btn16: // 8
                agregarTexto("8");
                break;
            case R.id.btn17: // 9
                agregarTexto("9");
                break;
            case R.id.btn19: // 4
                agregarTexto("4");
                break;
            case R.id.btn20: // 5
                agregarTexto("5");
                break;
            case R.id.btn21: // 6
                agregarTexto("6");
                break;
            case R.id.btn23: // 1
                agregarTexto("1");
                break;
            case R.id.btn24: // 2
                agregarTexto("2");
                break;
            case R.id.btn25: // 3
                agregarTexto("3");
                break;
            case R.id.btn28: // 0
                agregarTexto("0");
                break;
            case R.id.btn26: // +
                agregarTexto("+");
                break;
            case R.id.btn22: // -
                agregarTexto("-");
                break;
            case R.id.btn18: // X (multiplicar)
                agregarTexto("x");
                break;
            case R.id.btn14:
                agregarTexto("÷");
                break;
            case R.id.btn13:
                raiz(); // raiz
                break;
            case R.id.btn30:
                resultado();
                break;
            case R.id.btn12:
                cuadrado();
                break;
            case R.id.btn10:
                aux = pantalla.getText().toString();
                del(aux);
                break;
            case R.id.btn11:
                reciproco();
                break;
            case R.id.btn8:
                limpiar();
                break;
            case R.id.btn9:
                limpiar();
                break;
        }
    }

    public  void agregarTexto(String txt){
        String aux = pantalla.getText().toString();
        pantalla.setText(aux + txt);
    }
    public void resultado(){
        String aux = pantalla.getText().toString();
        for(int i = 0; i < aux.length(); i++){
            switch (aux.charAt(i)){
                case '+':
                    sumar();
                    break;
                case '-':
                    restar();
                    break;
                case 'x':
                    multiplicar();
                    break;
                case '÷':
                    dividir();
                    break;
            }
        }
    }

    public void sumar(){
        String aux = pantalla.getText().toString();
        int tambaja = 0; // tamaño de la parte baja de la operacion
        String baja = ""; // donde se guarda la parte baja de la operacion
        String alta ="";

        //Obtenemos la parte alta
        for (int i=0; i < aux.length(); i++){
            if (aux.charAt(i) =='+'){
                break;
            }else{
                baja = baja + aux.charAt(i);
                tambaja++;
            }
        }
        //Obtenemos la parte baje
        for (int i = tambaja + 1; i < aux.length();i++)
            alta = alta + aux.charAt(i);

        float resultado = Float.parseFloat(baja) + Float.parseFloat(alta);
        aux = Float.toString(resultado);
        pantalla.setText(aux);
    }

    public void restar(){
        String aux = pantalla.getText().toString();
        int tambaja = 0; // tamaño de la parte baja de la operacion
        String baja = ""; // donde se guarda la parte baja de la operacion
        String alta ="";

        //Obtenemos la parte alta
        for (int i=0; i < aux.length(); i++){
            if (aux.charAt(i) =='-'){
                break;
            }else{
                baja = baja + aux.charAt(i);
                tambaja++;
            }
        }
        //Obtenemos la parte baje
        for (int i = tambaja + 1; i < aux.length();i++)
            alta = alta + aux.charAt(i);

        float resultado = Float.parseFloat(baja) - Float.parseFloat(alta);
        aux = Float.toString(resultado);
        pantalla.setText(aux);
    }

    public void multiplicar(){
        String aux = pantalla.getText().toString();
        int tambaja = 0; // tamaño de la parte baja de la operacion
        String baja = ""; // donde se guarda la parte baja de la operacion
        String alta ="";

        //Obtenemos la parte alta
        for (int i=0; i < aux.length(); i++){
            if (aux.charAt(i) =='x'){
                break;
            }else{
                baja = baja + aux.charAt(i);
                tambaja++;
            }
        }
        //Obtenemos la parte baje
        for (int i = tambaja + 1; i < aux.length();i++)
            alta = alta + aux.charAt(i);

        float resultado = Float.parseFloat(baja) * Float.parseFloat(alta);
        aux = Float.toString(resultado);
        pantalla.setText(aux);
    }

    public void dividir(){
        String aux = pantalla.getText().toString();
        int tambaja = 0; // tamaño de la parte baja de la operacion
        String baja = ""; // donde se guarda la parte baja de la operacion
        String alta ="";

        //Obtenemos la parte alta
        for (int i=0; i < aux.length(); i++){
            if (aux.charAt(i) =='÷'){
                break;
            }else{
                baja = baja + aux.charAt(i);
                tambaja++;
            }
        }
        //Obtenemos la parte baje
        for (int i = tambaja + 1; i < aux.length();i++)
            alta = alta + aux.charAt(i);

        try{
            float resultado = Float.parseFloat(baja) / Float.parseFloat(alta);
            aux = Float.toString(resultado);
        }catch (Exception e){
            aux = "No se puede dividir entre 0";
            pantalla.setText(aux);
        }finally {
            pantalla.setText(aux);
        }
    }

    public void raiz(){
        String aux = pantalla.getText().toString();
        float resu = (float)Math.sqrt(Float.parseFloat(aux));
        aux = "√(" + aux + ")" + "=" + resu;
        pantalla.setText(aux);
    }

    public void cuadrado(){
        String aux = pantalla.getText().toString();
        float resu = (float)Math.pow(Float.parseFloat(aux), 2);
        aux = aux + "^2" + "=" + resu;
        pantalla.setText(aux);
    }

    public void reciproco(){
        String aux = pantalla.getText().toString();
        float resu = (float)Math.pow(Float.parseFloat(aux), -1);
        aux = "1/" + aux + "=" + resu;
        pantalla.setText(aux);
    }

    public void del(String aux){
        String naux="";
        for (int i = 0; i < aux.length()-1; i++)
            naux = naux + aux.charAt(i);
        pantalla.setText(naux);
    }
    public void limpiar(){
        pantalla.setText("");
    }
}

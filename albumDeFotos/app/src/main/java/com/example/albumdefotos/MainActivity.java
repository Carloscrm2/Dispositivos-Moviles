package com.example.albumdefotos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView txt1;
    Button btn1;
    Button btn2;
    ImageView foto;
    int i = 0; // Para recorrer las fotos
    int longitudAlbum;
    int id_foto[] = {R.drawable.venom, R.drawable.daltonico,
                     R.drawable.ipn, R.drawable.tele};
    String nombre_foto[] = {"Venom", "Daltonico", "Ipn", "Telematica"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt1 = (TextView) findViewById(R.id.nombre);
        btn1 = (Button) findViewById(R.id.boton1);
        btn2 = (Button) findViewById(R.id.boton2);
        foto = (ImageView) findViewById(R.id.img);

        foto.setImageResource(id_foto[0]);
        txt1.setText(nombre_foto[0]);
        longitudAlbum = id_foto.length;

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.boton1){
            i--;
            if(i <= -1)
                i = 3;
            foto.setImageResource(id_foto[i]);
            txt1.setText(nombre_foto[i]);
        }
        else if(view.getId() == R.id.boton2){
            i++;
            if(i >= longitudAlbum)
                i = 0;
            foto.setImageResource(id_foto[i]);
            txt1.setText(nombre_foto[i]);
        }
    }
}



package com.example.animacionalbumfotos;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    AnimationDrawable animacion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button boton1 = (Button) findViewById(R.id.boton1);
        Button boton2 = (Button) findViewById(R.id.boton2);
        ImageView foto = (ImageView) findViewById(R.id.img);
        //foto.setImageResource(R.drawable.android);
        foto.setBackgroundResource(R.drawable.animacionfotos);
        /*foto.setAdjustViewBounds(true);
        foto.setVisibility(View.VISIBLE);*/


        animacion = new AnimationDrawable();
        int t = 1000;
        animacion.addFrame(getResources().getDrawable(R.drawable.android), t);
        animacion.addFrame(getResources().getDrawable(R.drawable.bosquebn), t);
        animacion.addFrame(getResources().getDrawable(R.drawable.daltonico), t);
        animacion.addFrame(getResources().getDrawable(R.drawable.kitty), t);

        animacion.setOneShot(false);
        foto.setImageDrawable(animacion);
        boton1.setOnClickListener(this);
        boton2.setOnClickListener(this);
    }
    @Override
    public void onClick(View view){
        if (view.getId() == R.id.boton2){
            animacion.start();
        }else{
            animacion.stop();
        }
    }
}
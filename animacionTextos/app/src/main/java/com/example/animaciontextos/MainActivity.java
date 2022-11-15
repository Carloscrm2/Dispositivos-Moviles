package com.example.animaciontextos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.texto2);
        Animation animacion = AnimationUtils.loadAnimation(this, R.anim.escalamiento);
        animacion.setFillAfter(true);
        animacion.setRepeatMode(Animation.RESTART);
        animacion.setRepeatCount(2);
        tv.startAnimation(animacion);
    }
}
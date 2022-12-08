package com.example.listeneraplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.BounceInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Animation.AnimationListener{
    TextView tv1;
    Animation escalamiento, transparencia, traslacion;
    int i = 10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = (TextView) findViewById(R.id.texto1);

        //Animacion de transparencia (Aparicion)
        transparencia = new AlphaAnimation(0,1);
        transparencia.setInterpolator(new LinearInterpolator());
        transparencia.setDuration(2000);
        transparencia.setRepeatMode(Animation.RESTART);
        transparencia.setRepeatCount(10);
        tv1.startAnimation(transparencia);



        //Animacion de escalamiento
        int rs = ScaleAnimation.RELATIVE_TO_SELF;
        escalamiento = new ScaleAnimation(1, 2,1,3,rs,0.5f, rs,0.5f);
        escalamiento.setDuration(5000);
        escalamiento.setInterpolator(new LinearInterpolator());
        escalamiento.setFillAfter(true);
        //tv1.startAnimation(escalamiento);




        //Animacion de traslacion
        int rs2 = ScaleAnimation.RELATIVE_TO_SELF;
        traslacion  = new TranslateAnimation(rs2,0, rs2,0,rs2, 0, rs2,0.3f);
        traslacion.setDuration(5000);
        traslacion.setInterpolator(new BounceInterpolator());
        traslacion.setFillAfter(true);
        //tv1.startAnimation(traslacion);

        transparencia.setAnimationListener(this);
        escalamiento.setAnimationListener(this);
        traslacion.setAnimationListener(this);

    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        if (animation == transparencia){
            tv1.setText("GAME\nOVER");
            tv1.startAnimation(escalamiento);
        }
        if (animation==escalamiento){
            tv1.startAnimation(traslacion);
        }
    }

    @Override
    public void onAnimationRepeat(Animation animation) {
        if (animation == transparencia){
            i--;
            tv1.setText("CONTADOR = " + i);
        }
    }
}
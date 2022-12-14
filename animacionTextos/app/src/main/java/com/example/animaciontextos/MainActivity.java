package com.example.animaciontextos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    Animation anim1, anim2, anim3, anim4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnimationSet animaciones = new AnimationSet(true);
        tv = (TextView) findViewById(R.id.texto2);

        // animacion de traslacion
        int rs1 = TranslateAnimation.RELATIVE_TO_SELF;
        anim1 = new TranslateAnimation(rs1, 0, rs1, 0,rs1,0,rs1,3);
        anim1.setInterpolator(new LinearInterpolator());
        anim1.setFillAfter(false);
        anim1.setDuration(3000);
        anim1.setRepeatMode(Animation.RESTART);

        int rs2 = TranslateAnimation.RELATIVE_TO_SELF;
        anim2 = new RotateAnimation(0, 360, rs2, 0.5f, rs2,0.5f);
        anim2.setInterpolator(new LinearInterpolator());
        anim2.setFillAfter(true);
        anim2.setRepeatCount(1);
        anim2.setDuration(1000);
        anim2.setRepeatMode(Animation.RESTART);
        anim2.setStartOffset(3000);

        anim3 = new ScaleAnimation(1,2,1,2 );
        anim3.setFillAfter(true);
        anim3.setRepeatCount(1);
        anim3.setDuration(1000);
        anim3.setStartOffset(3000);

        animaciones.addAnimation(anim1);
        animaciones.addAnimation(anim2);
        animaciones.addAnimation(anim3);
        tv.startAnimation(animaciones);
    }
}
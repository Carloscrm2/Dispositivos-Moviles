package com.example.animacionlayoutjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.BounceInterpolator;
import android.view.animation.LayoutAnimationController;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Animation.AnimationListener{

    TextView txt1;
    LinearLayout ly1;
    Animation anim1, anim2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ly1 = (LinearLayout) findViewById(R.id.ly1);

        //Animacion de traslacion
        int rs1 = TranslateAnimation.RELATIVE_TO_SELF;
        anim1 = new TranslateAnimation(rs1, 1f, rs1, 0f, rs1, 0f, rs1, 0f);
        anim1.setDuration(3000);
        anim1.setInterpolator(new LinearInterpolator());
        anim1.setFillAfter(true);

        //Animacion de escalamiento
        int rs2 = ScaleAnimation.RELATIVE_TO_SELF;
        anim2 = new TranslateAnimation(rs2, 1f, rs2, 0f, rs2, 0f, rs2, 0f);
        anim2.setDuration(3000);
        anim2.setInterpolator(new BounceInterpolator());
        anim2.setFillAfter(true);

        //txt1 = (TextView) findViewById(R.id.txt1);
        //txt1.startAnimation(anim1);

        // Creando el objeto layoutAnimation
        LayoutAnimationController animacionLayout = new LayoutAnimationController(anim1);
        animacionLayout.setDelay(1);
        animacionLayout.setOrder(LayoutAnimationController.ORDER_NORMAL);

        ly1.setLayoutAnimation(animacionLayout);

        ly1.setLayoutAnimationListener(this);


    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        txt1 = (TextView) findViewById(R.id.txt5);
        txt1.setText("FIN DE ANIMACION");
        txt1.startAnimation(anim2);
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
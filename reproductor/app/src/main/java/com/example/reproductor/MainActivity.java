package com.example.reproductor;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    MediaPlayer player;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn1 = (Button) findViewById(R.id.tillThereWasYou);
        Button btn2 = (Button) findViewById(R.id.devilInHereHeart);
        Button btn3 = (Button) findViewById(R.id.pausa);
        Button btn4 = (Button) findViewById(R.id.parar);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.tillThereWasYou:
                if (player!=null){
                    player.reset();
                }
                player = MediaPlayer.create(this,R.raw.till_there_was_you);
                player.seekTo(0);
                player.start();
                break;
            case R.id.devilInHereHeart:
                if (player!=null){
                    player.reset();
                }
                player = MediaPlayer.create(this,R.raw.hold_me_tight);
                player.seekTo(0);
                player.start();
                break;
            case R.id.pausa:
                if (player.isPlaying()){
                    player.pause();
                }else{
                    try {
                        if (player!=null){
                            player.start();
                        }
                    }catch (Exception e){
                        System.out.println(e);
                    }
                }
                break;
            case R.id.parar:
                if (player!=null)
                    player.stop();
                break;
        }
    }

    @Override
    public void onPause(){
        super.onPause();
        if (player.isPlaying()){
            player.pause();
        }
    }

    @Override
    public void onRestart(){
        super.onRestart();
        player.start();
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        if (player!=null){
            player.release();
        }
    }
}
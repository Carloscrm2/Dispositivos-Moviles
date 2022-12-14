package com.example.reproductorvideo;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button play, pause, stop;
    VideoView video;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play = (Button) findViewById(R.id.play);
        pause = (Button) findViewById(R.id.pause);
        stop = (Button) findViewById(R.id.stop);

        video = (VideoView) findViewById(R.id.video1);
        //video.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video));

        play.setOnClickListener(this);
        pause.setOnClickListener(this);
        stop.setOnClickListener(this);

        MediaController controles = new MediaController(this);
        video.setMediaController(controles);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.play:
                video.start();
                break;
            case R.id.pause:
                video.pause();
                break;
            case R.id.stop:
                video.suspend();
                video.seekTo(0);
                video.resume();
                break;
        }
    }
}
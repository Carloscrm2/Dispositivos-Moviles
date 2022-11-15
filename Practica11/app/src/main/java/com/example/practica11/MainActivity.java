package com.example.practica11;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout ly1 = (LinearLayout) findViewById(R.id.layout1);
        TextView tv1 = (TextView) findViewById(R.id.textView1);

    }

    public class VistaGrafico extends View {
        int color; String texto; int x,y;

    }
}
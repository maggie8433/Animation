package com.example.maggie.animationexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {

    private ImageView image;
    private Button swing;
    private Button fade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image = (ImageView) findViewById(R.id.image);

        swing = (Button) findViewById(R.id.swing);

        swing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                image.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.swing));

            }
        });

        fade = (Button)findViewById(R.id.fade);

        fade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                image.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade));
            }
        });


    }
}

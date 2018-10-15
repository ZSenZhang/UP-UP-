package com.example.asus.treegrow;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.example.apple.camera_face.R;

public class MainActivity extends AppCompatActivity {

    ImageView iv;
    Button growBtn;
    Button next1Btn;
    Animation scaleAnimation;
    Intent intent = new Intent();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        scaleAnimation = AnimationUtils.loadAnimation(this,R.anim.scale);
        growBtn = (Button)findViewById(R.id.button_grow);
        next1Btn = (Button)findViewById(R.id.button_next);
        iv = (ImageView)findViewById(R.id.imageView1);
        iv.setVisibility(View.INVISIBLE);


        growBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv.startAnimation(scaleAnimation);
            }
        });

        next1Btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                intent.setClass(MainActivity.this, Main2Activity.class);
                startActivity(intent);
            }
        });
    };
}






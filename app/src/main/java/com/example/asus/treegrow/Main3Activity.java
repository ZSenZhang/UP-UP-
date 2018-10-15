package com.example.asus.treegrow;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.apple.camera_face.R;

public class Main3Activity extends AppCompatActivity {

    ImageView iv;
    Button oneBtn;
    Button twoBtn;
    Button threeBtn;
    Button fourBtn;
    Button fiveBtn;
    Button sixBtn;
    Button sevenBtn;
    Animation growAnimation;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


        oneBtn = (Button)findViewById(R.id.button1);
        twoBtn = (Button)findViewById(R.id.button2);
        threeBtn = (Button)findViewById(R.id.button3);
        fourBtn = (Button)findViewById(R.id.button4);
        fiveBtn = (Button)findViewById(R.id.button5);
        sixBtn = (Button)findViewById(R.id.button6);
        sevenBtn = (Button)findViewById(R.id.button7);
        iv = (ImageView)findViewById(R.id.imageView6);
        sp = this.getSharedPreferences("day_type", Context.MODE_PRIVATE);
        int flag = sp.getInt("flag",0);
        if(flag == 1){
            int type1 = sp.getInt("temp",0);
            int type2 = sp.getInt("day1",0);
            int type3 = sp.getInt("day2",0);
            int type4 = sp.getInt("day3",0);
            int type5 = sp.getInt("day4",0);
            int type6 = sp.getInt("day5",0);
            int type7 = sp.getInt("day6",0);
            sp.edit().putInt("flag",0).putInt("day1",type1).putInt("day2",type2).putInt("day3",type3).putInt("day4",type4).putInt("day5",type5).putInt("day6",type6).putInt("day7",type7).commit();
        }

        int i = sp.getInt("day1",0);
        if(i == 0)
        {
            iv.setImageResource(R.drawable.note);
        }
        else if(i == 1)
        {
            iv.setImageResource(R.drawable.tree1);
        }
        else if(i == 2)
        {
            iv.setImageResource(R.drawable.tree2);
        }
        else if(i == 3)
        {
            iv.setImageResource(R.drawable.tree3);
        }
        else
        {
            iv.setImageResource(R.drawable.tree4);
        }
        Log.i("debug main3",String.valueOf(i));

        growAnimation = AnimationUtils.loadAnimation(this,R.anim.scale);

        iv.startAnimation(growAnimation);

        oneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int type = sp.getInt("day1",0);
                if(type == 0)
                {
                    iv.setImageResource(R.drawable.note);
                }
                else if(type == 1)
                {
                    iv.setImageResource(R.drawable.tree1);
                }
                else if(type == 2)
                {
                    iv.setImageResource(R.drawable.tree2);
                }
                else if(type == 3)
                {
                    iv.setImageResource(R.drawable.tree3);
                }
                else
                {
                    iv.setImageResource(R.drawable.tree4);
                }
                iv.startAnimation(growAnimation);

            }
        });

        twoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int type = sp.getInt("day2",0);
                if(type == 0)
                {
                    iv.setImageResource(R.drawable.note);
                }
                else if(type == 1)
                {
                    iv.setImageResource(R.drawable.tree1);
                }
                else if(type == 2)
                {
                    iv.setImageResource(R.drawable.tree2);
                }
                else if(type == 3)
                {
                    iv.setImageResource(R.drawable.tree3);
                }
                else
                {
                    iv.setImageResource(R.drawable.tree4);
                }
                iv.startAnimation(growAnimation);

            }
        });

        threeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int type = sp.getInt("day3",0);
                if(type == 0)
                {
                    iv.setImageResource(R.drawable.note);
                }
                else if(type == 1)
                {
                    iv.setImageResource(R.drawable.tree1);
                }
                else if(type == 2)
                {
                    iv.setImageResource(R.drawable.tree2);
                }
                else if(type == 3)
                {
                    iv.setImageResource(R.drawable.tree3);
                }
                else
                {
                    iv.setImageResource(R.drawable.tree4);
                }
                iv.startAnimation(growAnimation);

            }
        });

        fourBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int type = sp.getInt("day4",0);
                if(type == 0)
                {
                    iv.setImageResource(R.drawable.note);
                }
                else if(type == 1)
                {
                    iv.setImageResource(R.drawable.tree1);
                }
                else if(type == 2)
                {
                    iv.setImageResource(R.drawable.tree2);
                }
                else if(type == 3)
                {
                    iv.setImageResource(R.drawable.tree3);
                }
                else
                {
                    iv.setImageResource(R.drawable.tree4);
                }
                iv.startAnimation(growAnimation);

            }
        });

        fiveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int type = sp.getInt("day5",0);
                if(type == 0)
                {
                    iv.setImageResource(R.drawable.note);
                }
                else if(type == 1)
                {
                    iv.setImageResource(R.drawable.tree1);
                }
                else if(type == 2)
                {
                    iv.setImageResource(R.drawable.tree2);
                }
                else if(type == 3)
                {
                    iv.setImageResource(R.drawable.tree3);
                }
                else
                {
                    iv.setImageResource(R.drawable.tree4);
                }
                iv.startAnimation(growAnimation);

            }
        });

        sixBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int type = sp.getInt("day6",0);
                if(type == 0)
                {
                    iv.setImageResource(R.drawable.note);
                }
                else if(type == 1)
                {
                    iv.setImageResource(R.drawable.tree1);
                }
                else if(type == 2)
                {
                    iv.setImageResource(R.drawable.tree2);
                }
                else if(type == 3)
                {
                    iv.setImageResource(R.drawable.tree3);
                }
                else
                {
                    iv.setImageResource(R.drawable.tree4);
                }
                iv.startAnimation(growAnimation);

            }
        });

        sevenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int type = sp.getInt("day7",0);
                if(type == 0)
                {
                    iv.setImageResource(R.drawable.note);
                }
                else if(type == 1)
                {
                    iv.setImageResource(R.drawable.tree1);
                }
                else if(type == 2)
                {
                    iv.setImageResource(R.drawable.tree2);
                }
                else if(type == 3)
                {
                    iv.setImageResource(R.drawable.tree3);
                }
                else
                {
                    iv.setImageResource(R.drawable.tree4);
                }
                iv.startAnimation(growAnimation);

            }
        });



    }
}

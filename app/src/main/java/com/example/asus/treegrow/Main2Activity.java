package com.example.asus.treegrow;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.apple.camera_face.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static com.example.apple.camera_face.R.*;

public class Main2Activity extends AppCompatActivity {

    ImageView iv;
  //  Button prev2Btn;
    Button next2Btn;
    Animation growAnimation;
    EditText edittext1;
    EditText edittext2;
    Intent intent2 = new Intent();
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main2);
        sp = this.getSharedPreferences("day_type", Context.MODE_PRIVATE);
        growAnimation = AnimationUtils.loadAnimation(this, anim.scale);
     //   prev2Btn = (Button)findViewById(id.button2_prev);
        next2Btn = (Button)findViewById(id.button2_next);
        iv = (ImageView)findViewById(id.imageView4);
        //edittext1 = (EditText)findViewById(id.edittext1);
        //edittext2 = (EditText)findViewById(id.editText2);
        iv.startAnimation(growAnimation);
        //Date inidate = new Date(1900,01,01);
        //新页面接收数据
        Bundle bundle = this.getIntent().getExtras();
        //接收cost-time值
        final long costTime = bundle.getLong("cost_time");
        Log.i("获取到的cost-time值为",""+costTime);

      /*  prev2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });*/

        next2Btn.setOnClickListener(new View.OnClickListener(){
                                        @Override
                                        public void onClick(View v){

                                            Log.i("onClick: ","onClick: ");
                                            Calendar date = Calendar.getInstance();
                                            int curYear = date.get(Calendar.YEAR);
                                            Log.i("onClickpreday: ",String.valueOf(curYear));

                                            int curMon = date.get(Calendar.MONTH) + 1;

                                            int curday = date.get(Calendar.DAY_OF_MONTH)+1;

                                            int preYear = sp.getInt("Year",0);
                                            int preMon = sp.getInt("Month",0);
                                            int preDay = sp.getInt("Day",0);
                                            Log.i("onClickpreday: ",String.valueOf(curMon));
                                            Log.i("onClickpreday: ",String.valueOf(curday));
                                            Log.i("onClickpreday: ",String.valueOf(preYear));
                                            Log.i("onClickpreday: ",String.valueOf(preMon));
                                            Log.i("onClickpreday: ",String.valueOf(preDay));

                                            Log.i("onClickpreday: ","onClickpreday: ");

                                            if ((curYear > preYear) || (curYear == preYear && curMon > preMon) || (curYear == preYear && curMon == preMon && curday > preDay)) {
                                                Log.i("onClickif: ","onClickif: ");
                                                /*if(TextUtils.isEmpty(type))
                                                {
                                                    sp.edit().putInt("flag",1).putInt("temp",0).putInt("Year",curYear).putInt("Month",curMon).putInt("Day",curday).commit();
                                                }
                                                else {*/
                                                    int i;
                                                    if(costTime <= 60000)
                                                    {
                                                        i = 1;
                                                    }
                                                    else if(costTime > 60000 && costTime <=180000)
                                                    {
                                                        i = 2;
                                                    }
                                                    else if(costTime > 180000 && costTime <=600000)
                                                    {
                                                        i = 3;
                                                    }
                                                   /* else if(costTime >= 600000)
                                                    {
                                                        i = 0;
                                                    }*/
                                                    else
                                                    {
                                                        i = 0;
                                                    }
                                                Log.i("onClicksp: ","onClicksp: ");
                                                    sp.edit().putInt("flag",1).putInt("temp",i).putInt("Year",curYear).putInt("Month",curMon).putInt("Day",curday).commit();

                                                    //Log.i("debug main2",day);
                                                    Log.i("debug main2",String.valueOf(i));



                                            }

                                            intent2.setClass(Main2Activity.this, Main3Activity.class);
                                            startActivity(intent2);
                                            //String day = edittext1.getText().toString();
                                            //String type = edittext2.getText().toString();

                                        }
                                    }
        );
    }
}

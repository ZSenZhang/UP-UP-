package com.example.cjk.myclock;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.example.apple.camera_face.R;

/**
 * Created by apple on 2018/4/13.
 */

public class RingActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    //    private Alarmlast alt;
    private long start; //闹钟响的时间（ms）
    private long end; //闹钟停止的时间（ms）

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ring);
        Log.i("RingActivity","闹钟响了");

        mediaPlayer = MediaPlayer.create(this,R.raw.newyork);
        mediaPlayer.start();
//        alt.timeStart();
        start = System.currentTimeMillis();
    }

    public void stop(View view)
    {
        Intent intent = new Intent();
        intent.setClass(RingActivity.this, com.example.apple.camera_face.MainActivity.class);
/*
        Bundle bundle = new Bundle();
        bundle.putLong( "start",start );
        intent.putExtras(bundle);*/

        startActivityForResult(intent, 0);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if (requestCode==0 & resultCode==1){
            Log.e("TAG", "onActivityResult");
            end = data.getLongExtra("end",0);
            long cost_time = end - start;
            mediaPlayer.stop();
            Intent intent = new Intent();
            intent.setClass(RingActivity.this, com.example.asus.treegrow.Main2Activity.class);

            Bundle bundle = new Bundle();
            bundle.putLong( "cost_time",cost_time );
            intent.putExtras(bundle);
            startActivityForResult(intent, 0);

            Log.i("RingActivity",""+cost_time);
        }
    }

}

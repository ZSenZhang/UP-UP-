package com.example.cjk.myclock;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.apple.camera_face.R;
import com.example.asus.treegrow.Main3Activity;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private PendingIntent pendingIntent;
    private AlarmManager alarmManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
    }

    public void setAlarmOne(View view){
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                Calendar c = Calendar.getInstance();
                c.set(Calendar.HOUR_OF_DAY,hourOfDay);
                c.set(Calendar.MINUTE,minute);

                Intent intent = new Intent(MainActivity.this, RingActivity.class);
//                intent.setAction("com.example.cjk.ring");
                pendingIntent = PendingIntent.getActivity(MainActivity.this,0,intent,0);

                alarmManager.set(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(), pendingIntent);

                TextView textView = (TextView) findViewById(R.id.clock);

                textView.setText("闹钟时间 "+hourOfDay+":"+minute);

            }
        }, hour, minute, true);
        Log.i("test","闹钟设定成功");

        timePickerDialog.show();
    }

    public void setAlarmCycle(View view){
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                Calendar c = Calendar.getInstance();
                c.set(Calendar.HOUR_OF_DAY,hourOfDay);
                c.set(Calendar.MINUTE,minute);

                Intent intent = new Intent(MainActivity.this, RingActivity.class);
//                intent.setAction("com.example.cjk.ring");
                pendingIntent = PendingIntent.getActivity(MainActivity.this,0,intent,0);

                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(), 24*3600*1000,pendingIntent);

            }
        }, hour, minute, true);
        Log.i("test","闹钟设定成功");

        timePickerDialog.show();
    }

    public void onClick(View v){

        Intent intent2 = new Intent();
        intent2.setClass(MainActivity.this, Main3Activity.class);
        startActivity(intent2);

        //String day = edittext1.getText().toString();
        //String type = edittext2.getText().toString();

        Calendar date = Calendar.getInstance();
        int curYear = date.get(Calendar.YEAR);
        int curMon = date.get(Calendar.MONTH) + 1;
        int curday = date.get(Calendar.DAY_OF_MONTH);
/*
        int preYear = sp.getInt("Year",0);
        int preMon = sp.getInt("Month",0);
        int preDay = sp.getInt("Day",0);

            sp.edit().putInt("flag",1).putInt("temp",i).putInt("Year",curYear).putInt("Month",curMon).putInt("Day",curday).commit();*/

            Log.i("debug main-main3","main-main3");

        }

    public void cancelAlarmCycle(View view){
        alarmManager.cancel(pendingIntent);
    }
}

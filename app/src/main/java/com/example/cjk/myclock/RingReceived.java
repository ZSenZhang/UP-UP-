package com.example.cjk.myclock;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by apple on 2018/4/13.
 */

public class RingReceived extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent){
//        Log.i("test","闹钟响了");
        if("com.example.cjk.ring".equals(intent.getAction())){
            Log.i("test","闹钟响了");
            Intent intent1 = new Intent(context, RingActivity.class);

            intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent1);
        }
    }
}

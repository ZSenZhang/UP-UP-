package com.example.cjk.myclock;


/**
 * Created by apple on 2018/4/13.
 */

public class Alarmlast {
    private long start,end;

    public void timeStart(){
        start = System.currentTimeMillis();
    }

    public void timeEnd(){
;       end = System.currentTimeMillis();
    }

    public long getLastTime(){
        return end - start;
    }
}

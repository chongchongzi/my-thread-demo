package com.chongzi.thread;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @Description 定时器
 * @Author chongzi
 * @Date 2019/10/30 19:38
 **/
public class TimerThread {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("timertask is run");
            }
        },0,1000);
    }
}

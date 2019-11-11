package com.chongzi.thread;

/**
 * @Description 轻量级锁
 * 保证可见性的前提
 * 多个线程拿到的是同一把锁，否则是保证不了的。
 * @Author chongzi
 * @Date 2019/10/30 20:33
 **/
public class VolatileThread2 {
    public volatile boolean run = false;

    public static void main(String[] args) {

        VolatileThread2 d = new VolatileThread2();

        new Thread(new Runnable() {

            @Override
            public void run() {
                for(int i = 1;i<=10;i++) {
                    System.err.println("执行了第 " + i + " 次");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                d.run = true;
            }
        }).start();

        new Thread(new Runnable() {

            @Override
            public void run() {
                while(!d.run) {
                    // 不执行
                }
                System.err.println("线程2执行了...");
            }
        }).start();


    }
}

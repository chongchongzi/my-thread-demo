package com.chongzi.thread;

/**
 * @Description 轻量级锁
 * 保证可见性的前提
 * 多个线程拿到的是同一把锁，否则是保证不了的。
 * @Author chongzi
 * @Date 2019/10/30 20:33
 **/
public class VolatileThread {
    public volatile int a = 1;

    public synchronized int getA(){
        return a;
    }

    public synchronized void setA(int a){
        try {
            Thread.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.a = a;
    }

    public static void main(String[] args) {
        VolatileThread volatileThread = new VolatileThread();
        volatileThread.a = 10;

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(volatileThread.a);
            }
        }).start();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("最终的结果为:"+volatileThread.getA());
    }
}

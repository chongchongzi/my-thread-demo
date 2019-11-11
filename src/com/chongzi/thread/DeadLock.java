package com.chongzi.thread;

/**
 * @Description 死锁
 * @Author chongzi
 * @Date 2019/10/30 20:27
 **/
public class DeadLock {
    private Object obj1 = new Object();
    private Object obj2 = new Object();


    public void a () {
        synchronized (obj1) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (obj2) {
                System.out.println("a");
            }
        }
    }

    public void b () {
        synchronized (obj2) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (obj1) {
                System.out.println("b");
            }
        }
    }

    public static void main(String[] args) {

        DeadLock d = new DeadLock();

        new Thread(new Runnable() {

            @Override
            public void run() {
                d.a();
            }
        }).start();
        new Thread(new Runnable() {

            @Override
            public void run() {
                d.b();
            }
        }).start();
    }
}

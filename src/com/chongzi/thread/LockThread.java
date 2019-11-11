package com.chongzi.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description Lock接口的认识与使用
 * @Author chongzi
 * @Date 2019/11/7 17:46
 **/
public class LockThread {
    private int value;
    Lock lock = new ReentrantLock();
    Lock l1 = new ReentrantLock();

    /**
     * @return
     */
    public  int getNext() {
        lock.lock();
        int a = value ++;
        lock.unlock();
        return a;
    }

    public static void main(String[] args) {

        LockThread s = new LockThread();

        new Thread(new Runnable() {

            @Override
            public void run() {
                while(true) {
                    System.out.println(Thread.currentThread().getName() + " " + s.getNext());
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {

            @Override
            public void run() {
                while(true) {
                    System.out.println(Thread.currentThread().getName() + " " + s.getNext());
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {

            @Override
            public void run() {
                while(true) {
                    System.out.println(Thread.currentThread().getName() + " " + s.getNext());
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

    }
}

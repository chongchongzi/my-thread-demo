package com.chongzi.thread;

import java.util.Random;

/**
 * @Description 自旋
 * @Author chongzi
 * @Date 2019/10/30 20:23
 **/
public class SpinLock {

    public static void main(String[] args) {
        new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " 线程执行...");

                try {
                    Thread.sleep(new Random().nextInt(2000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + " 线程执行完毕了...");
            }
        }).start();
        new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " 线程执行...");

                try {
                    Thread.sleep(new Random().nextInt(2000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + " 线程执行完毕了...");
            }
        }).start();
        new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " 线程执行...");

                try {
                    Thread.sleep(new Random().nextInt(2000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + " 线程执行完毕了...");
            }
        }).start();
        new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " 线程执行...");

                try {
                    Thread.sleep(new Random().nextInt(2000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + " 线程执行完毕了...");
            }
        }).start();
        new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " 线程执行...");

                try {
                    Thread.sleep(new Random().nextInt(2000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + " 线程执行完毕了...");
            }
        }).start();

        while(Thread.activeCount() != 1) {
            // 自旋
        }
        System.out.println("所有的线程执行完毕了...");
    }
}

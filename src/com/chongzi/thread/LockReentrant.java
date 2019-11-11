package com.chongzi.thread;

/**
 * @Description 锁重入
 * @Author chongzi
 * @Date 2019/10/30 20:19
 **/
public class LockReentrant {
    public synchronized void a(){
        System.out.println("a");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void b(){
        System.out.println("b");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        LockReentrant lockReentrant1 = new LockReentrant();
        LockReentrant lockReentrant2 = new LockReentrant();

        new Thread(new Runnable() {
            @Override
            public void run() {
                lockReentrant1.a();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                lockReentrant2.b();
            }
        }).start();

    }
}

package com.chongzi.thread;

/**
 * @Description 使用AQS改造自己的锁
 * @Author chongzi
 * @Date 2019/11/8 11:35
 **/
public class MyAqsLockMain {

    private int value;
    private MyAqsLock lock = new MyAqsLock();

    public int next() {
        lock.lock();

        try {
            Thread.sleep(300);
            return value++;
        } catch (InterruptedException e) {
            throw new RuntimeException();
        } finally {
            lock.unlock();
        }
    }

    public void a() {
        lock.lock();
        System.out.println("a");
        b();
        lock.unlock();
    }

    public void b() {
        lock.lock();
        System.out.println("b");
        lock.unlock();
    }

    public static void main(String[] args) {

        MyAqsLockMain m = new MyAqsLockMain();

        new Thread(new Runnable() {

            @Override
            public void run() {
                m.a();
            }
        }).start();

    }
}

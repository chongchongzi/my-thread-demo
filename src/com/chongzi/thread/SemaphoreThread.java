package com.chongzi.thread;

import java.util.concurrent.Semaphore;

/**
 * @Description Semaphore 是一个计数信号量，必须由获取它的线程释放。
 * 常用于限制可以访问某些资源的线程数量，例如通过 Semaphore 限流。
 * @Author chongzi
 * @Date 2019/11/11 14:54
 **/
public class SemaphoreThread {
    public void method (Semaphore semaphore) {

        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + " is run ...");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        semaphore.release();
    }


    public static void main(String[] args) {

        SemaphoreThread d = new SemaphoreThread();
        Semaphore semaphore = new Semaphore(10);

        while(true) {

            new Thread(new Runnable() {
                @Override
                public void run() {
                    d.method(semaphore);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }).start();
        }


    }
}

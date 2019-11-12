package com.chongzi.thread;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;

/**
 * @Description CyclicBarrier（可重用屏障/栅栏） 类似于 CountDownLatch（倒计数闭锁），它能阻塞一组线程直到某个事件的发生。
 * 与闭锁的关键区别在于，所有的线程必须同时到达屏障位置，才能继续执行。
 * 闭锁用于等待事件，而屏障用于等待其他线程。 CyclicBarrier 可以使一定数量的线程反复地在屏障位置处汇集。
 * 当线程到达屏障位置时将调用 await() 方法，这个方法将阻塞直到所有线程都到达屏障位置。
 * 如果所有线程都到达屏障位置，那么屏障将打开，此时所有的线程都将被释放，而屏障将被重置以便下次使用。
 * @Author chongzi
 * @Date 2019/11/11 14:48
 **/
public class CyclicBarrierThread {
    Random random = new Random();

    public void meeting(CyclicBarrier barrier) {
        try {
            Thread.sleep(random.nextInt(4000));
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " 到达会议室，等待开会..");

        if(Thread.currentThread().getName().equals("Thread-7")) {
            // Thread.currentThread().interrupt();
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            barrier.reset();

        }

        try {
            barrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        CyclicBarrierThread demo = new CyclicBarrierThread();

        CyclicBarrier barrier = new CyclicBarrier(10, new Runnable() {
            @Override
            public void run() {
                System.out.println("好！我们开始开会...");
            }
        });

        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    demo.meeting(barrier);
                }
            }).start();
        }

        // 监控等待线程数
        new Thread(new Runnable() {

            @Override
            public void run() {
                while(true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("等待的线程数 " + barrier.getNumberWaiting());
                    System.out.println("is broken " + barrier.isBroken());
                }
            }
        }).start();
    }
}

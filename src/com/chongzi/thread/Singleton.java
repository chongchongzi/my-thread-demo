package com.chongzi.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Singleton {
    private static volatile Singleton instance;

    /**
     * 双重检查加锁
     * @return
     */
    public static Singleton getInstance() {
        // 自旋
        if(instance == null){
            synchronized (Singleton.class){
                if(instance == null){
                    instance = new Singleton();// 指令重排序

                    // 申请一块内存空间   // 1
                    // 在这块空间里实例化对象  // 2
                    // instance的引用指向这块空间地址   // 3
                }
            }
        }
        return instance;
    }

    private Singleton() {
    }

    // 多线程的环境下
    // 必须有共享资源
    // 对资源进行非原子性操作

    public static void main(String[] args) {
/*        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        Singleton s3 = Singleton.getInstance();
        Singleton s4 = Singleton.getInstance();

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);*/

        ExecutorService threadPool = Executors.newFixedThreadPool(20);
        for (int i = 0; i < 20; i++) {
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + ":" + Singleton.getInstance());
                }
            });

        }
    }
}

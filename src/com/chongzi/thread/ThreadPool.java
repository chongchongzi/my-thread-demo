package com.chongzi.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description 线程池
 * @Author chongzi
 * @Date 2019/10/30 19:41
 **/
public class ThreadPool {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 1000; i++) {
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            });
        }
        threadPool.shutdown();
    }
}

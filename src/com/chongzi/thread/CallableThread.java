package com.chongzi.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Description 有返回值的线程
 * @Author chongzi
 * @Date 2019/10/30 19:31
 **/
public class CallableThread implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("正在进行计算...");
        Thread.sleep(3000);
        return 1;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CallableThread callableThread = new CallableThread();
        FutureTask<Integer> task = new FutureTask<>(callableThread);

        Thread t = new Thread(task);
        t.start();
        System.out.println("我先干点别的...");
        Integer result = task.get();
        System.out.println("线程执行的结果是："+ result);
    }
}

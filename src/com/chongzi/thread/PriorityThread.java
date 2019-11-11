package com.chongzi.thread;

/**
 * @Description 线程优先级
 * @Author chongzi
 * @Date 2019/10/30 19:58
 **/
public class PriorityThread {

    public static void main(String[] args) {
        Thread t1 = new Thread( new Targer());
        Thread t2 = new Thread( new Targer());

        t1.setPriority(1);
        t2.setPriority(Thread.MAX_PRIORITY);

        t1.start();
        t2.start();
    }

    static class Targer implements Runnable{

        @Override
        public void run() {
            while (true){
                System.out.println(Thread.currentThread().getName() + "...");
            }
        }
    }
}

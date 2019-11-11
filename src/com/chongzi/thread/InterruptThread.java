package com.chongzi.thread;

/**
 * @Description 中断线程
 * @Author chongzi
 * @Date 2019/10/30 18:23
 **/
public class InterruptThread extends Thread {

    public InterruptThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        while (!interrupted()){
            System.out.println(getName() + "线程执行了...");
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        InterruptThread interruptThread1 = new InterruptThread("first-thread");
        InterruptThread interruptThread2 = new InterruptThread("first-thread");

        interruptThread1.start();
        interruptThread2.start();

        //interruptThread1.stop();
        interruptThread1.interrupt();
    }
}

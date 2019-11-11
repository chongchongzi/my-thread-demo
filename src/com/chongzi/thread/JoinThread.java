package com.chongzi.thread;

/**
 * @Description 该方法的定义是等待该线程终止。其实就是join()方法将挂起调用线程的执行，直到被调用的对象完成它的执行
 * @Author chongzi
 * @Date 2019/11/8 15:18
 **/
public class JoinThread {
    public void target (Thread joinThread) {

        System.out.println("target 方法执行了...");
        try {
            joinThread.start();
            joinThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("join 线程执行完毕...");

    }


    public static void main(String[] args) {
        JoinThread d = new JoinThread();

        Thread joinThread = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    d.a();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

        new Thread(new Runnable() {

            @Override
            public void run() {
                d.target(joinThread);
            }
        }).start();
    }


    protected void a() throws InterruptedException {
        System.out.println("join 线程进入");
        Thread.sleep(1000);
    }
}

package com.chongzi.thread;

/**
 * @Description 序列
 * @Author chongzi
 * @Date 2019/10/30 19:51
 **/
public class Sequence {
    private int value;

    /**
     * synchronized 放在普通方法上，内置锁就是当前类的实例
     * @return
     */
    public synchronized int getNext(){
        return value ++;
    }

    /**
     * 修饰静态方法，内置锁是当前的Class字节码对象
     * Sequence.class
     * @return
     */
    public static synchronized int getPrevious(){
        return 0;
    }

    public int xx(){
        synchronized (Sequence.class){
            if(value > 0){
                return value;
            } else {
                return -1;
            }
        }
    }

    public static void main(String[] args) {
        Sequence s = new Sequence();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    System.out.println(Thread.currentThread().getName() + " " + s.getNext());
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    System.out.println(Thread.currentThread().getName() + " " + s.getNext());
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    System.out.println(Thread.currentThread().getName() + " " + s.getNext());
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    System.out.println(Thread.currentThread().getName() + " " + s.getNext());
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}

package com.chongzi.thread;

import java.util.concurrent.Exchanger;

/**
 * @Description Exchanger类可用于两个线程之间交换信息。可简单地将Exchanger对象理解为一个包含两个格子的容器，通过exchanger方法可以向两个格子中填充信息。当两个格子中的均被填充时，该对象会自动将两个格子的信息交换，然后返回给线程，从而实现两个线程的信息交换。
 * @Author chongzi
 * @Date 2019/11/11 15:06
 **/
public class ExchangerThread {
    public void a (Exchanger<String> exch) {

        System.out.println("a 方法执行...");

        try {
            System.out.println("a 线程正在抓取数据...");
            Thread.sleep(2000);
            System.out.println("a 线程抓取到数据...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String res = "12345";

        try {
            System.out.println("a 等待对比结果...");
            exch.exchange(res);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void b (Exchanger<String> exch) {
        System.out.println("b 方法开始执行...");
        try {
            System.out.println("b 方法开始抓取数据...");
            Thread.sleep(4000);
            System.out.println("b 方法抓取数据结束...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String res = "12345";

        try {
            String value = exch.exchange(res);
            System.out.println("开始进行比对...");
            System.out.println("比对结果为：" + value.equals(res));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        ExchangerThread d = new ExchangerThread();
        Exchanger<String> exch = new Exchanger<>();
        new Thread(new Runnable() {
            @Override
            public void run() {
                d.a(exch);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                d.b(exch);
            }
        }).start();

    }
}

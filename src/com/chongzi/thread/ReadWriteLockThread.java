package com.chongzi.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Description 读写锁
 * @Author chongzi
 * @Date 2019/11/7 18:17
 **/
public class ReadWriteLockThread {
    private Map<String, Object> map = new HashMap<>();

    private ReadWriteLock rwl = new ReentrantReadWriteLock();

    private Lock r = rwl.readLock();
    private Lock w = rwl.writeLock();

    public Object get(String key) {
        r.lock();
        System.out.println(Thread.currentThread().getName() + " 读操作在执行..");
        try {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return map.get(key);
        } finally {
            r.unlock();
            System.out.println(Thread.currentThread().getName() + " 读操执行完毕..");
        }
    }

    public void put(String key, Object value) {
        w.lock();
        System.out.println(Thread.currentThread().getName() + " 写操作在执行..");
        try {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            map.put(key, value);
        } finally {
            w.unlock();
            System.out.println(Thread.currentThread().getName() + " 写操作执行完毕..");
        }
    }

    public static void main(String[] args) {


        ReadWriteLockThread d = new ReadWriteLockThread();
        d.put("key1", "value1");

//		new Thread(new Runnable() {
//			@Override
//			public void run() {
//				d.put("key1", "value1");
//			}
//		}).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(d.get("key1"));
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(d.get("key1"));
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(d.get("key1"));
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(d.get("key1"));
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(d.get("key1"));
            }
        }).start();

//		new Thread(new Runnable() {
//			@Override
//			public void run() {
//				d.put("key3", "value3");
//			}
//		}).start();


    }
}

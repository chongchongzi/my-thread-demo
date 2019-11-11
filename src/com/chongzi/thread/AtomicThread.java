package com.chongzi.thread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @Description 原子类使用
 * @Author chongzi
 * @Date 2019/11/7 17:23
 **/
public class AtomicThread {
    private AtomicInteger value  = new AtomicInteger(0);

    private int [] s = {2,1,4,6};

    AtomicIntegerArray a = new AtomicIntegerArray(s);


    AtomicReference<User> user = new AtomicReference<>();

    AtomicIntegerFieldUpdater<User> old =  AtomicIntegerFieldUpdater.newUpdater(User.class, "old");

    /**
     * @return
     */
    public  int getNext() {

        User user = new User();
        System.out.println(old.getAndIncrement(user));
        System.out.println(old.getAndIncrement(user));
        System.out.println(old.getAndIncrement(user));



        a.getAndIncrement(2);
        a.getAndAdd(2, 10);
        return value.getAndIncrement();
    }

    public static void main(String[] args) {

        AtomicThread s = new AtomicThread();

        new Thread(new Runnable() {

            @Override
            public void run() {
//				while(true) {
                System.out.println(Thread.currentThread().getName() + " " + s.getNext());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//				}
            }
        }).start();

//		new Thread(new Runnable() {
//
//			@Override
//			public void run() {
//				while(true) {
//					System.out.println(Thread.currentThread().getName() + " " + s.getNext());
//					try {
//						Thread.sleep(100);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//				}
//			}
//		}).start();
//
//		new Thread(new Runnable() {
//
//			@Override
//			public void run() {
//				while(true) {
//					System.out.println(Thread.currentThread().getName() + " " + s.getNext());
//					try {
//						Thread.sleep(100);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//				}
//			}
//		}).start();

    }

    public class User {

        private String name;

        public volatile int old;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getOld() {
            return old;
        }

        public void setOld(int old) {
            this.old = old;
        }

    }
}

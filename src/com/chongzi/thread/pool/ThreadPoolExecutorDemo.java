package com.chongzi.thread.pool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPoolExecutorDemo {
	
	public static void main(String[] args) {
		ThreadPoolExecutor threadPool = new ThreadPoolExecutor(10, 50, 10, TimeUnit.DAYS, new ArrayBlockingQueue<>(10),new ThreadPoolExecutor.CallerRunsPolicy());
		AtomicInteger count = new AtomicInteger();
		for(int i = 0; i < 100 ;i ++) {
			threadPool.execute(new Runnable() {
				@Override
				public void run() {
					System.out.println(Thread.currentThread().getName());
					count.getAndIncrement();
				}
			});
		}
		
		threadPool.shutdown();
		
		
		while(Thread.activeCount() > 1) {
			
		}
		System.out.println(count.get());
	}

}

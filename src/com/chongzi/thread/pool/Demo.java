package com.chongzi.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Demo {
	
	public static void main(String[] args) {
		
		
		// 10个线程来处理大量的任务
//		ThreadPoolExecutor pool = new ThreadPoolExecutor(10, 10, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
		ExecutorService pool = Executors.newFixedThreadPool(10);
//		ExecutorService pool = Executors.newCachedThreadPool();
//		ExecutorService pool = Executors.newSingleThreadExecutor();
//		ScheduledExecutorService pool = Executors.newScheduledThreadPool(10);
//		ExecutorService pool = Executors.newWorkStealingPool();

		while(true) {
			
			Future<?> f = pool.submit(new Runnable() {
				
				@Override
				public void run() {
					
				}
			});
			
			
//			pool.schedule(new Runnable() {
//				
//				@Override
//				public void run() {
//					System.out.println(Thread.currentThread().getName());
//				}
//			}, 5, TimeUnit.SECONDS);
			
			
//			pool.execute(new Runnable() {
//				
//				@Override
//				public void run() {
//					System.out.println(Thread.currentThread().getName());
//					try {
//						Thread.sleep(100);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//				}
//			});
		}
		
	}

}

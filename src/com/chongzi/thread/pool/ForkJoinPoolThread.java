package com.chongzi.thread.pool;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;
/**
 * @Description Java7 提供了ForkJoinPool来支持将一个任务拆分成多个“小任务”并行计算，再把多个“小任务”的结果合并成总的计算结果。
 * ForkJoinPool是ExecutorService的实现类，因此是一种特殊的线程池。
 * @Author chongzi
 * @Date 2019/11/12 9:53
 **/
public class ForkJoinPoolThread extends RecursiveTask<Integer> {
	
	private int begin;
	private int end;
	
	public ForkJoinPoolThread(int begin, int end) {
		this.begin = begin;
		this.end = end;
	}
	
	private static final int threshold = 2;

	@Override
	protected Integer compute() {
		System.out.println(Thread.currentThread().getName() + " 进入 " + begin + " " + end);
		if(end - begin <= threshold) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println(Thread.currentThread().getName() + " 计算完毕..." + begin + " " + end);
			return begin + end;
		}
		
		int middle = (begin + end) / 2;
		
		ForkJoinPoolThread s = new ForkJoinPoolThread(begin, middle);
		ForkJoinPoolThread l = new ForkJoinPoolThread(middle + 1, end);
		
		s.fork();
		l.fork();
		
		
		int a = s.join();
		int b = l.join();
		System.out.println(Thread.currentThread().getName() + " join " + a + " " + b);
		
		return a + b;
	}
	
	public static void main(String[] args) throws Exception {
		ForkJoinPool pool = new ForkJoinPool(20);
		
		ForkJoinPoolThread c = new ForkJoinPoolThread(1, 8);
		Future<Integer> f = pool.submit(c);
		System.out.println(f.get());
		
	}

}

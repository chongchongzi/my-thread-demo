package com.chongzi.thread.communication;

import java.util.concurrent.TimeUnit;

public class Demo {

	private volatile int signal;
	
	public synchronized void set () {
		signal = 1;
		notifyAll(); // notify�������������һ������wait״̬���߳�
		 // notifyAll�������еĴ���wait�̣߳����ᵽʱ��Ƭ���߳�ֻ��һ��
		System.out.println("�����߳̽���֮�����߿�ʼ...");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public synchronized int get () {
		System.out.println(Thread.currentThread().getName() + " ����ִ����...");
		if(signal != 1) {
			try {
				wait();
				System.out.println("����֮��");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName() + " ����ִ�����...");
		return signal;
	}
	
	public static void main(String[] args) {
		
		Demo d = new Demo();
		Target1 t1 = new Target1(d);
		Target2 t2 = new Target2(d);
		
		new Thread(t2).start();
		new Thread(t2).start();
		new Thread(t2).start();
		new Thread(t2).start();
		
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		new Thread(t1).start();
		
	}
}

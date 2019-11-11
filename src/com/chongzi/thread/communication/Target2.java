package com.chongzi.thread.communication;

public class Target2 implements Runnable {
	
	private Demo demo;

	public Target2(Demo demo) {
		this.demo = demo;
	}

	@Override
	public void run() {
		demo.get();
	}

}

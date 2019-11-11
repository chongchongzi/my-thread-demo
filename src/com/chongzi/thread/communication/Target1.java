package com.chongzi.thread.communication;

public class Target1 implements Runnable {
	
	private Demo demo;
	
	public Target1(Demo demo) {
		this.demo = demo;
	}

	@Override
	public void run() {
		demo.set();
	}

}

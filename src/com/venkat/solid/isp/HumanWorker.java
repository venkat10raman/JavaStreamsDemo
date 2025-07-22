package com.venkat.solid.isp;

public class HumanWorker implements Eatable, Workable {

	@Override
	public void work() {
		System.out.println("Human is working...");
	}

	@Override
	public void eat() {
		System.out.println("Human is eating...");
	}

}

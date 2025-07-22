package com.venkat.solid.lsp;

public class Sparrow implements Bird, Flyable {

	@Override
	public void fly() {
		System.out.println("Flying");
	}

	@Override
	public void eat() {
		System.out.println("Sparrow is eating seeds...");
	}

}

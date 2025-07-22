package com.venkat.designpattern.abstractfactory;

public class MacOSButton implements Button {

	@Override
	public void render() {
		System.out.println("Rendering a macOS button...");
	}

}

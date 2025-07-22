package com.venkat.designpattern.abstractfactory;

public class MacOSCheckbox implements Checkbox {

	@Override
	public void check() {
		System.out.println("Checking a macOS checkbox...");
	}

}

package com.venkat.designpattern.abstractfactory;

public class WindowsCheckbox implements Checkbox {

	@Override
	public void check() {
		System.out.println("Checking a Windows checkbox...");
	}

}

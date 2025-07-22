package com.venkat.solid.dip;

public class Mouse implements InputDevice {

	@Override
	public void input() {
		System.out.println("Clicking with mouse...");
	}

}

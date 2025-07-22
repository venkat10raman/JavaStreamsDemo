package com.venkat.solid.dip;

public class Keyboard implements InputDevice{

	@Override
    public void input() {
        System.out.println("Typing on keyboard...");
    }
	
}

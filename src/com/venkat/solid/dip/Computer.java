package com.venkat.solid.dip;


/*
 * Dependency Inversion Principle (DIP)
 * Definition: High-level modules should not depend on low-level modules;
 * both should depend on abstractions.
 * Abstractions should not depend on details;
 * details should depend on abstractions.
 */
public class Computer {

	private InputDevice inputDevice;

    public Computer(InputDevice inputDevice) {
        this.inputDevice = inputDevice;
    }

    public void start() {
        inputDevice.input();
        System.out.println("Computer started...");
    }
    
}

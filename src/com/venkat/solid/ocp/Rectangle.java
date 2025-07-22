package com.venkat.solid.ocp;

public class Rectangle implements Shape {
	
	private double width, length;
	
	public Rectangle(double width, double length) {
		this.width = width;
		this.length = length;
	}

	@Override
	public double calculateArea() {
		return width * length;
	}

}

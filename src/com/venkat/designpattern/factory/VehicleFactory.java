package com.venkat.designpattern.factory;

public class VehicleFactory {
	
	public static Vehicle createVehicle(String type) {
		if (type.equalsIgnoreCase("Car")) {
            return new Car();
        } else if (type.equalsIgnoreCase("Bike")) {
            return new Bike();
        } else {
            throw new IllegalArgumentException("Unknown vehicle type: " + type);
        }
	}
	
	
	public static void main(String[] args) {
        Vehicle vehicle1 = VehicleFactory.createVehicle("Car");
        vehicle1.drive();

        Vehicle vehicle2 = VehicleFactory.createVehicle("Bike");
        vehicle2.drive();
    }

}

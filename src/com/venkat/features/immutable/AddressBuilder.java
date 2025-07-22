package com.venkat.features.immutable;

public class AddressBuilder {
	
	private String city;
    private String street;
    
    public AddressBuilder setCity(String city) {
        this.city = city;
        return this;
    }
    
    public AddressBuilder setStreet(String street) {
    	this.street = street;
    	return this;
    }
    
    public Address build() {
    	return new Address(city, street);
    }
}

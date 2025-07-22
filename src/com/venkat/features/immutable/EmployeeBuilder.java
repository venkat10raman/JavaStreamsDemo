package com.venkat.features.immutable;

import java.util.ArrayList;
import java.util.List;

public class EmployeeBuilder {
	private String name;
    private List<Address> addressList = new ArrayList<>();
    
	public EmployeeBuilder setName(String name) {
		this.name = name;
		return this;
	}
	
	public EmployeeBuilder setAddressList(List<Address> addressList) {
		this.addressList = addressList;
		return this;
	}
	
	public EmployeeBuilder setAddress(Address address) {
		this.addressList.add(new Address(address.getCity(), address.getStreet()));
		return this;
	}
    
    public Employee build() {
    	return new Employee(name, addressList);
    }
}

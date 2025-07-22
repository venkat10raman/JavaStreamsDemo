package com.venkat.features.immutable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Employee {
	private final String name;
    private final List<Address> addressList;
    
    public Employee(String name, List<Address> addressList) {
    	this.name = name;
    	this.addressList = deepCopy(addressList);
    }

	private List<Address> deepCopy(List<Address> list) {
		List<Address> copy = new ArrayList<>();
		for(Address address : list) {
			copy.add(new Address(address.getCity(), address.getStreet()));
		}
		return copy;
	}

	public String getName() {
		return name;
	}

	public List<Address> getAddressList() {
		return Collections.unmodifiableList(this.addressList);
	}
    
}

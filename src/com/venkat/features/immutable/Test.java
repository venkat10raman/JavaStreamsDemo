package com.venkat.features.immutable;

public class Test {

	public static void main(String[] args) {
		Address a1 = new AddressBuilder()
				.setCity("Bangalore")
				.setStreet("MG Road")
				.build();

		Address a2 = new AddressBuilder()
				.setCity("Chennai")
				.setStreet("Anna Salai")
				.build();

		Employee emp = new EmployeeBuilder()
				.setName("Kiran")
				.setAddress(a1)
				.setAddress(a2)
				.build();

		System.out.println(emp.getName());
		System.out.println(emp.getAddressList());

		// Try modifying the list to verify immutability
		try {
			emp.getAddressList().add(a1);
		} catch (UnsupportedOperationException e) {
			System.out.println("Modification not allowed: " + e.getMessage());
		}
	}

}

package com.venkat;

public class Test {

	public static void main(String[] args) {
		
		callEM();
	}
	
	public static void callEM() {
		EmployeeManagement em = new EmployeeManagement();
		em.mostExperiencedEmployee();
		em.totalMaleFemale();
	}
	
	public static void callPM() {
		ProductManagement pm = new ProductManagement();
		pm.mapAndConvertToList();
		pm.totalPrice();
		pm.costliestProduct();
		pm.cheapestProduct();
		pm.convertToSet();
		pm.convertToMap();
	}
	
	public static void callSM() {
		StudentManagement sm = new StudentManagement();
		sm.usePredicate();
		sm.useConsumer();
		sm.useFunction();
		sm.useSupplier();
	}

}

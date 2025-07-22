package com.venkat.features.record.intraface;

public record Product(String name, double price, String description) implements Sellable {

	@Override
	public double getPrice() {
		return price;
	}

	@Override
	public String getDescription() {
		return description;
	}

	public static void main(String[] args) {
		Product laptop = new Product("Laptop", 999.99, "High-performance laptop");
		System.out.println(laptop); 
		// Output: Product[name=Laptop, price=999.99, description=High-performance laptop]
		System.out.println("Price: $" + laptop.getPrice()); 
		System.out.println("Description: " + laptop.getDescription()); 
	}



}

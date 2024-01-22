package com.venkat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class ProductManagement {
	
	private String dash = "-------------------------------------";
	
	public void mapAndConvertToList() {
		System.out.println(dash);
		List<Product> productList = getProductList();
		List<String> productNameList = productList.stream()
			.map(Product::getName)
			.collect(Collectors.toList());
			
		productNameList.stream().forEach(System.out::println);
		System.out.println(dash);
	}
	
	public void totalPrice() {
		System.out.println(dash);
		System.out.print("Sum of all products price is :::: ");
		List<Product> productList = getProductList();
		Double totalPrice = productList.stream()
			.collect(Collectors.summingDouble(Product::getPrice));
		System.out.println(totalPrice);
		System.out.println(dash);
	}
	
	public void costliestProduct() {
		System.out.println(dash);
		System.out.println("Costliest Product Details :::: ");
		List<Product> productList = getProductList();
		Optional<Product> op =  productList.stream()
			.max(Comparator.comparingDouble(Product::getPrice));
		Product product = op.get();
		System.out.println(product.getName());
		System.out.println(product.getPrice());
		System.out.println(dash);
	}
	
	public void cheapestProduct() {
		System.out.println(dash);
		System.out.println("Cheapest Product Details :::: ");
		List<Product> productList = getProductList();
		Optional<Product> op = productList.stream()
				.min(Comparator.comparingDouble(Product::getPrice));
		
		Product product = op.get();
		System.out.println(product.getName());
		System.out.println(product.getPrice());
		System.out.println(dash);
		
	}
	
	public void convertToSet() {
		System.out.println(dash);
		System.out.println("Converting Product Details to Set :::: ");
		List<Product> productList = getProductList();
		Set<String> productSet = productList.stream()
			.map(Product::getName)
			.collect(Collectors.toSet());
		System.out.println(productSet);
		System.out.println(dash);
		
	}
	
	public void convertToMap() {
		System.out.println(dash);
		System.out.println("Converting Product Details to Map :::: ");
		List<Product> productList = getProductList();
		
		Map<Integer, String> productMap = productList.stream()
				.collect(Collectors.toMap(Product::getId, Product::getName));
		
		System.out.println(productMap);
		System.out.println(dash);
	}
	
	
	public List<Product> getProductList() {
		List<Product> productList = new ArrayList<Product>();  

		productList.add(new Product(1,"HP",25000f));  
		productList.add(new Product(2,"Dell",30000f));  
		productList.add(new Product(3,"Lenevo",28000f));  
		productList.add(new Product(4,"Sony",28000f));  
		productList.add(new Product(5,"Apple",90000f));
		
		return productList;
	}

}

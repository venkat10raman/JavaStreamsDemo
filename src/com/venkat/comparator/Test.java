package com.venkat.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		List<Product> list = getProductList();
		list.stream().map(p -> p.getName() + " - ").forEach(System.out::print);
		System.out.println();
		Collections.sort(list);
		list.stream().map(p -> p.getName() + " - ").forEach(System.out::print);
		System.out.println();
		
		Collections.sort(list, Comparator.reverseOrder());
		list.stream().map(p -> p.getName() + " - ").forEach(System.out::print);
		System.out.println();
		
		Collections.sort(list, Comparator.comparing(Product::getId));
		list.stream().map(p -> p.getName() + " - ").forEach(System.out::print);
		System.out.println();
		
	}

	private static List<Product> getProductList() {
		List<Product> list = new ArrayList<>();
		list.add(new Product(1, "IPhone"));
		list.add(new Product(2, "Google"));
		list.add(new Product(3, "Nokia"));
		list.add(new Product(4, "Samsung"));
		list.add(new Product(5, "Sony"));
		list.add(new Product(1, "Motorola"));
		return list;
	}

}

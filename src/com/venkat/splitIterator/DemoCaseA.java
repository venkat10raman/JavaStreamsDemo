package com.venkat.splitIterator;

import java.util.ArrayList;
import java.util.Spliterator;

public class DemoCaseA {

	public static void main(String[] args) {
		// Creating an ArrayList
		ArrayList<String> arrayList = new ArrayList<>();
		arrayList.add("Java");
		arrayList.add("Python");
		arrayList.add("C++");
		arrayList.add("JavaScript");

		// Obtaining a Spliterator from ArrayList
		Spliterator<String> spliterator = arrayList.spliterator();

		// // Iterating elements using the .forEachRemaining() method
		spliterator.forEachRemaining(System.out::println);

		arrayList.clear();
		arrayList.add("Ruby");
		arrayList.add("Rust");
		arrayList.add("PHP");
		arrayList.add("Go");

		// Obtaining a Spliterator from ArrayList
		spliterator = arrayList.spliterator();
		
		// Splitting the Spliterator
		Spliterator<String> secondHalf = spliterator.trySplit();
		
		System.out.println("First Half:");
		
		// Iterating elements using the .forEachRemaining() method
	    spliterator.forEachRemaining(System.out::println);
	    System.out.println("Second Half:");
	    secondHalf.forEachRemaining(System.out::println);
	}

}

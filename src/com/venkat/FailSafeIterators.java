package com.venkat;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class FailSafeIterators {

	public static void main(String[] args) {

		concurrentArrayList();
		System.out.println("----------------");

		concurrentHashMap();
		System.out.println("----------------");
	}

	private static void concurrentHashMap() {

		// Creating a ConcurrentHashMap
		ConcurrentHashMap<String, Integer> map
		= new ConcurrentHashMap<String, Integer>();

		map.put("ONE", 1);
		map.put("TWO", 2);
		map.put("THREE", 3);
		map.put("FOUR", 4);

		// Getting an Iterator from map
		Iterator<String> it = map.keySet().iterator();

		while (it.hasNext()) {
			String key = (String)it.next();
			System.out.println(key + " : " + map.get(key));

			// This will reflect in iterator.
			// Hence, it has not created separate copy
			map.put("SEVEN", 7);
		}

	}

	private static void concurrentArrayList() {
		CopyOnWriteArrayList<Integer> list = 
				new CopyOnWriteArrayList<>(new Integer[] { 1, 3, 5, 8 });

		Iterator<Integer> itr = list.iterator();
		Integer number = null;
		while (itr.hasNext()) {
			number = (Integer)itr.next();
			System.out.println(number);
			if (number == 8) {
				// This will not print,
				// hence it has created separate copy
				list.add(14);
			}
		}

		System.out.println(list);

		itr = list.iterator();
		while (itr.hasNext()) {
			number = (Integer)itr.next();
			System.out.println(number);

			// This will not print,
			// hence it has created separate copy
			list.add(number + 100);
		}
		System.out.println(list);
	}
}

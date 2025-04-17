package com.venkat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Map;

public class FailFastIterators {

	public static void main(String[] args) {

		
		
		try {
			demoHashMap();
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("----------------");
		}
		
		try {
			demoArrayList();
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("----------------");
		}
		
		try {
			demoArrayListWithIterator();
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("----------------");
		}

	}
	
	private static void demoArrayListWithIterator() {
		ArrayList<String> list = new ArrayList<>();
		list.add("Australia");
		list.add("New Zealand");
		list.add("India");
		list.add("Italy");
		list.add("USA");
		
		Iterator<String> iterator = list.iterator();
		
		String name = null;
		while(iterator.hasNext()) {
			name = iterator.next();
			System.out.println(name);
			if (name.equals("India")) {
				// will not throw Exception
				iterator.remove();
            }
		}
		
		System.out.println(list);
		
		iterator = list.iterator();
		
		while(iterator.hasNext()) {
			name = iterator.next();
			System.out.println(name);
			if (name.equals("USA")) {
				// will throw Exception on
                // next call of next() method
				list.remove(list.indexOf(name));
            }
		}
	}

	private static void demoArrayList() {
		ArrayList<String> list = new ArrayList<>();
		list.add("Australia");
		list.add("New Zealand");
		list.add("India");
		list.add("Italy");
		list.add("USA");
		
		ListIterator<String> iterator = list.listIterator();
		
		String name = null;
		while(iterator.hasNext()) {
			name = iterator.next();
			System.out.println(name);
			if (name.equals("India")) {
                
				// will not throw Exception
				iterator.remove();
            }
		}
		
		System.out.println(list);
		
		iterator = list.listIterator();
		
		while(iterator.hasNext()) {
			name = iterator.next();
			System.out.println(name);
			if (name.equals("USA")) {
				// will throw Exception on
                // next call of next() method
				list.remove(list.indexOf(name));
            }
		}
	}

	private static void demoHashMap() {
		Map<String, String> cityCode
		= new HashMap<String, String>();
		cityCode.put("Delhi", "India");
		cityCode.put("Moscow", "Russia");
		cityCode.put("New York", "USA");
		
		Iterator<String> iterator = cityCode.keySet().iterator();
		
		while(iterator.hasNext()) {
			System.out.println(cityCode.get(iterator.next()));
			
			// adding an element to Map
            // exception will be thrown on next call
            // of next() method.
			cityCode.put("Istanbul", "Turkey");
		}
		
	}

}

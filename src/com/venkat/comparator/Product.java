package com.venkat.comparator;

import java.util.Objects;

public class Product implements Comparable<Product>{
    private int id;
    private String name;

    public Product(int id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product e = (Product) o;
        return id == e.id && Objects.equals(name, e.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name); 
    }

	@Override
	public int compareTo(Product other) {
		return Integer.compare(id, other.id);
	}
}

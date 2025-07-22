package com.venkat.features.record;

public record A2Person(String name, int age) {
	
	// Custom constructor with validation
    public A2Person {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or blank");
        }
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
    }
    
    // Additional method
    public String greeting() {
        return "Hello, I am " + name + " and I am " + age + " years old.";
    }
    
	public static void main(String[] args) {
		try {
            A2Person person = new A2Person("Alice", 30);
            System.out.println(person); // Output: Person[name=Alice, age=30]
            System.out.println(person.greeting()); // Output: Hello, I am Alice and I am 30 years old.
            
            // This will throw an exception
            A2Person invalid = new A2Person("Jenny", -5);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage()); // Output: Error: Name cannot be null or blank
        }
	}

}

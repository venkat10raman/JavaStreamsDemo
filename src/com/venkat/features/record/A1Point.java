package com.venkat.features.record;

public record A1Point(int x, int y) {
	
	public int x() {
		return x;
	}

	public int y() {
		return y;
	}

	public static void main(String[] args) {
		A1Point p1 = new A1Point(3, 4);
		A1Point p2 = new A1Point(3, 4);
		
		// Access fields using automatically generated getters
        System.out.println("Point: (" + p1.x() + ", " + p1.y() + ")");
        
        // toString() is automatically implemented
        System.out.println(p1); // Output: Point[x=3, y=4]
        
        // equals() compares field values
        System.out.println(p1.equals(p2)); // Output: true
        
        // hashCode() is consistent with equals()
        System.out.println(p1.hashCode() == p2.hashCode()); // Output: true
	}

}

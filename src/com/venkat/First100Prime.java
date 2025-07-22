package com.venkat;

import java.util.stream.IntStream;

public class First100Prime {
	private static int count = 0;

	public static void main(String[] args) {
		System.out.println("First 100 Prime Numbers:");
		
		IntStream.iterate(2, n -> n + 1)
			.filter(First100Prime::isPrime)
			.limit(100)
			.forEachOrdered(n -> {
                // Format: 5 numbers per line, right-aligned
                System.out.printf("%5d", n);
                // New line after every 5 numbers
                if (isNthPrime()) System.out.println();
            });
	}
	
	private static boolean isPrime(int n) {
		if(n <=0) return false;
		if(n == 2) return true;
		if(n %2 ==0) return false;
		for(int i =3 ; i <= Math.sqrt(n) ; i += 2) {
			if(n % i ==0) return false;
		}
		return true;
	}
	
	private static boolean isNthPrime() {
        count++;
        return count % 5 == 0;
    }

}

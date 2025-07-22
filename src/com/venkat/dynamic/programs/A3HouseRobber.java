package com.venkat.dynamic.programs;

public class A3HouseRobber {

	public static void main(String[] args) {
		int[] houses = {5,3,10,10,15,7,20};
		System.out.println("Max House Rob :: " + houseRob(houses, houses.length-1));
		
		int[] dp = new int[houses.length];
		dp[0] = houses[0];
		dp[1] = Math.max(houses[0], houses[1]);
		System.out.println("Max House Rob :: " + houseRob(houses, houses.length-1, dp));
		System.out.println("Max House Rob :: " + houseRobBottomUp(houses, houses.length-1));
		System.out.println("Max House Rob :: " + houseRobBottomUp(houses));
	}
	
	// Top down approach
	// T.C O(2^n)
	// S.C O(2^n)
	private static int houseRob(int[] houses, int n) {
		if(n == 0) return houses[n];
		if(n == 1) return Math.max(houses[0], houses[0]);
		return Math.max(houses[n]+houseRob(houses, n-2), houseRob(houses, n-1));
	} 
	
	// Top down approach
	// T.C O(n)
	// S.C O(n)
	private static int houseRob(int[] houses, int n, int[] dp) {
		if(n <= 1) {
			return dp[n];
		}
		dp[n] = Math.max(houses[n]+houseRob(houses, n-2, dp),
				houseRob(houses, n-1, dp));
		return dp[n];
	}
	
	// Bottom up approach
	// T.C O(n)
	// S.C O(n)
	private static int houseRobBottomUp(int[] houses, int n) {
		int[] dp = new int[houses.length];
		dp[0] = houses[0];
		dp[1] = Math.max(houses[0], houses[1]);
		for(int i=2; i <= n; i++) {
			dp[i] = Math.max(houses[i]+dp[i-2], dp[i-1]);
		}
		return dp[n];
	}
	
	// Bottom up approach
	// T.C O(n)
	// S.C O(n)
	private static int houseRobBottomUp(int[] houses) {
		int n = houses.length-1;
		int prevLast = houses[0];
		int last = Math.max(houses[0], houses[1]), result = 0;
		for(int i=2; i <= n; i++) {
			result = Math.max(houses[i]+prevLast, last);
			prevLast = last;
			last = result;
		}
		return result;
	}

}

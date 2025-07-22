package com.venkat.dynamic.programs;

public class A2MinCostClimbingStairs {

	// each element is the cost to step up from the position
	// you are allowed to take one or two steps at a time
	// find the minimum cost required to reach the top
	public static void main(String[] args) {
		int[] stairs = {10,15,5,30,4,4,10};
		System.out.println("Naive Recursion :: " + mincost(stairs, stairs.length));
		int[] dp = new int[stairs.length + 1];
		System.out.println("Naive Recursion :: " + mincost(stairs, stairs.length, dp));
		
		System.out.println("Naive Recursion :: " + mincost(stairs));
	}
	
	// Top down approach
	// T.C O(2^n)
	// S.C O(2^n)
	private static int mincost(int[] stairs, int n) {
		if(n < 2) return 0;
		
		return Math.min(stairs[n-2] + mincost(stairs, n-2), 
				stairs[n-1] + mincost(stairs, n-1));
	}
	
	// Top down approach
	// T.C O(n)
	// S.C O(n)
	private static int mincost(int[] stairs, int n, int[] dp) {
		if(n < 2) {
			dp[n] = 0;
			return dp[n];
		};
		
		dp[n] = Math.min(stairs[n-2] + mincost(stairs, n-2), 
				stairs[n-1] + mincost(stairs, n-1));
		return dp[n];
	}
	
	// Top down approach
	// T.C O(n)
	// S.C constant
	private static int mincost(int[] stairs) {
		int top = stairs.length;
		
		int[] dp = new int[top+1];
		for(int i=2; i<=top; i++) {
			dp[i] = Math.min(dp[i-2]+stairs[i-2], dp[i-1]+stairs[i-1]);
		}
		
		int prevLast =0, last =0, result =0;
		for(int i=2; i<=top; i++) {
			result = Math.min(prevLast + stairs[i-2], last + stairs[i-1]);
			prevLast = last;
			last = result;
		}
		System.out.println(result);
		return dp[top];
	}
}

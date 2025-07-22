package com.venkat.dynamic.programs;

import java.util.Arrays;

public class A1Fibonacci {

	public static void main(String[] args) {
		int n = 10;
		System.out.println(n + " th Fibonnaci :: " + fib(n));
		
		int[] dp = new int[n+1];
		Arrays.fill(dp, -1);
		dp[0] = 0;
		dp[1] = 1;
		System.out.println(n + " th Fibonnaci :: " + fib(n, dp));
		
		System.out.println(n + " th Fibonnaci :: " + bottomUpFib(n));
	}
	
	
	// Top down approach
	// T.C O(2^n)
	// S.C O(2^n)
	private static int fib(int n) {
		if(n==0) return 0;
		if(n==1) return 1;
		
		return fib(n-1) + fib(n-2);
	}
	
	// Top down approach with memoization
	// T.C O(n)
	// S.C O(n)
	private static int fib(int n, int[] dp) {
		if(dp[n] != -1) {
			return dp[n];
		}
		dp[n] = fib(n-1, dp) + fib(n-2, dp);
		return dp[n];
	}
	
	// Bottom Up approach
	// T.C O(n)
	// S.C constant
	private static int bottomUpFib(int n) {
		int first = 0, second = 1, result = 0;
		int i = 2;
		while(i <= n) {
			result = first + second;
			first = second;
			second = result;
			i++;
		}
		return result;
	}

}

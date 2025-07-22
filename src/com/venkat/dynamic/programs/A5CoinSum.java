package com.venkat.dynamic.programs;

import java.util.Arrays;

public class A5CoinSum {

	public static void main(String[] args) {
		// given coin array and sum
		// find the no of ways to make the sum

		int[] coins = {1,2,3};
		int total = 4;
		System.out.println("No of ways :: " + coinSum(coins, total, 3));
		System.out.println("No of ways :: " + coinSum(coins, total));
		System.out.println("No of ways :: " + coinWays(coins, total));
	}

	private static int coinSum(int[] coins, int sum, int n) {
		if(sum == 0) return 1;
		if (sum < 0 || n <= 0) return 0;

		return coinSum(coins, sum, n-1) + //exclude coin
				coinSum(coins, sum-coins[n-1], n); //include coin
	}

	private static int coinWays(int[] coins, int sum) {
		int n = coins.length;
		int[][] dp = new int[n + 1][sum + 1];

		// Initialize with -1 (means uncomputed)
		for (int[] row : dp) {
			Arrays.fill(row, -1);
		}
		int result = coinSum(coins,sum,n,dp);
		System.out.println("-----------");
		for (int[] row : dp) {
			Arrays.toString(row);
		}
		System.out.println("-----------");
		return result;
	}

	private static int coinSum(int[] coins, int sum, int n, int[][] dp) {
		if (sum == 0) return 1;
		if (n == 0 || sum < 0) return 0;

		if (dp[n][sum] != -1) return dp[n][sum];

		// Include current coin + exclude current coin
		dp[n][sum] = coinSum(coins, sum, n-1,dp) + //exclude
				coinSum(coins, sum-coins[n-1], n, dp); // include (same coin again)
		return dp[n][sum];
	}

	private static int coinSum(int[] coins, int sum) {

		int[] dp = new int[sum+1];
		dp[0] = 1;
		for(int coin : coins) {
			for(int i=coin; i<= sum; i++) {
				dp[i] = dp[i-coin] + dp[i];
			}
		}
		System.out.println(Arrays.toString(dp));
		return dp[sum];
	}

}

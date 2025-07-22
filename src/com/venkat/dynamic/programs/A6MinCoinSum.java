package com.venkat.dynamic.programs;

import java.util.Arrays;

public class A6MinCoinSum {

	public static void main(String[] args) {
		int[] coins = {1,2,3};
		int total = 4;
		System.out.println("No of ways :: " + coinSum(coins, total));
		System.out.println("No of ways :: " + minCoinSum(coins, total));
		
		int[] dp = new int[total + 1];
        Arrays.fill(dp, -1);
        minCoinSum(coins, total, dp);
	}
	
	private static int minCoinSum(int[] coins, int sum, int[] dp) {
		
		if (sum == 0) return 0;
        if (sum < 0) return Integer.MAX_VALUE;
        if (dp[sum] != -1) return dp[sum];
        
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = minCoinSum(coins, sum - coin, dp);
            if (res != Integer.MAX_VALUE) {
                min = Math.min(min, res + 1);
            }
        }
        dp[sum] = min;
        return dp[sum];
	}

	private static int minCoinSum(int[] coins, int sum) {
		if(sum == 0) return 0;
		if(sum < 0) return Integer.MAX_VALUE;
		
		int min = Integer.MAX_VALUE;
		for(int coin : coins) {
			int result = minCoinSum(coins, sum-coin);
			if(result != Integer.MAX_VALUE) {
				min = Math.min(result+1, min);
			}
		}
		return min;
	}
	
	private static int coinSum(int[] coins, int sum) {
		int[] dp = new int[sum+1];
		Arrays.fill(dp, sum+1);
		dp[0] = 0;
		
		for(int coin : coins) {
			for(int i = coin; i <= sum; i++) {
				dp[i] = Math.min(dp[i], dp[i-coin]+1);
			}
		}
		System.out.println(Arrays.toString(dp));
		return dp[sum];
	}

}

package com.venkat.dynamic.programs;

import java.util.Arrays;

public class A8FrogJump {

	public static void main(String[] args) {
		int[] jumps = {1, 2, 3};
        int n = 4;
        System.out.println("Ways: " + countWays(n, jumps));
        
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println("Ways: " + countWays(n, jumps, dp));
        
        System.out.println("Ways: " + countWays(jumps, n));
	}
	
	private static int countWays(int n, int[] jumps) {
        if (n == 0) return 1;
        if (n < 0) return 0;

        int ways = 0;
        for (int jump : jumps) {
            ways += countWays(n - jump, jumps);
        }
        return ways;
    }
	
	private static int countWays(int n, int[] jumps, int[] dp) {
        if (n == 0) return 1;
        if (n < 0) return 0;
        if (dp[n] != -1) return dp[n];

        int ways = 0;
        for (int jump : jumps) {
            ways += countWays(n - jump, jumps, dp);
        }

        dp[n] = ways;
        return dp[n];
    }
	
	public static int countWays(int[] jumps, int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int jump : jumps) {
                if (i - jump >= 0) {
                    dp[i] = dp[i] + dp[i - jump];
                }
            }
        }

        return dp[n];
    }

}

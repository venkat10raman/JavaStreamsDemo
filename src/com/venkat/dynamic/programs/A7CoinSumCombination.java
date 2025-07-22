package com.venkat.dynamic.programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A7CoinSumCombination {

	public static void main(String[] args) {
		int[] coins = {1, 2, 5};
		int amount = 5;
		findUniqueCombinations(coins, amount);
	}

	private static void findUniqueCombinations(int[] coins, int amount) {
		List<List<Integer>> results = new ArrayList<>();

		// Sorting ensures combinations are built in non-decreasing order
		Arrays.sort(coins);
		
		backTrack(coins, amount, 0, new ArrayList<>(), results);
		System.out.println("Total unique combinations: " + results.size());
        for (List<Integer> combination : results) {
            System.out.println(combination);
        }
	}

	private static void backTrack(int[] coins, int amount, int index, List<Integer> current, List<List<Integer>> results) {
		if(amount == 0) {
			results.add(new ArrayList<>(current));
			return;
		}
		
		// If target is negative, stop this path
		if(amount < 0) return;
		
		for (int i = index; i < coins.length; i++) {
			if(coins[i] <= amount) {
				// Include the current coin
				current.add(coins[i]);
				// reuse current coin
				backTrack(coins, amount-coins[i], index, current, results);
				// backtrack by removing the last coin
				current.remove(current.size() - 1);
			}
			index++;
		}
	}

}

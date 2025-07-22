package com.venkat.dynamic.programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A9FrogJumpCombinations {

	public static void main(String[] args) {
		int[] jumps = {1, 2, 3};
        int n = 4;
        findCombinations(jumps, n);
	}
	
	private static void findCombinations(int[] jumps, int steps) {
		List<List<Integer>> results = new ArrayList<>();
		
		// Sorting ensures combinations are built in non-decreasing order
		Arrays.sort(jumps);
		
		backTrack(jumps, steps, new ArrayList<>(), results);
		System.out.println("Total unique combinations: " + results.size());
        for (List<Integer> combination : results) {
            System.out.println(combination);
        }
	}

	private static void backTrack(int[] jumps, int stepsRemaining, List<Integer> current, List<List<Integer>> results) {
		if(stepsRemaining == 0) {
			results.add(new ArrayList<>(current));
			return;
		}
		
		if(stepsRemaining < 0) return;
		
		for(int step : jumps) {
			if(step <= stepsRemaining) {
				// Include the current step
				current.add(step);
				// reuse current step
				backTrack(jumps, stepsRemaining-step, current, results);
				// backtrack by removing the last step
				current.remove(current.size()-1);
			}
		}
		
	}

}

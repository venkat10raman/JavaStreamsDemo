package com.venkat.dynamic.programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class B1SubSetSumCombinations {

	public static void main(String[] args) {
		int[] arr = {6,1, 3, 2, 1,1,1,1};
		int targetSum = 5;
		System.out.println("Array: " + Arrays.toString(arr));
		System.out.println("Target Sum: " + targetSum);
		subsetCombination(arr, targetSum);
	}

	private static List<List<Integer>> subsetCombination(int[] arr, int sum) {
		List<List<Integer>> result = new ArrayList<>();
		backTrack(arr, sum, 0, new ArrayList<>(), result);
		if (!result.isEmpty()) {
			System.out.println("All subsets with sum " + sum + ":");
			for (List<Integer> subset : result) {
				System.out.println(subset);
			}
			int subSetCount = subSetCount(arr, sum, arr.length-1);
			System.out.println(subSetCount == result.size());
		} else {
			System.out.println("No subsets found with the given sum");
		}
		return null;
	}

	private static void backTrack(int[] arr, int sum, int index, List<Integer> current, List<List<Integer>> result) {
		if(sum == 0) {
			result.add(new ArrayList<>(current));
			return;
		}
		
		if(index >= arr.length || sum < 0) {
			return;
		}
		
		// Include current element
		current.add(arr[index]);
		backTrack(arr, sum-arr[index], index+1, current, result);
		
		// Exclude current element
		current.remove(current.size()-1);
		backTrack(arr, sum, index+1, current, result);
	}
	
	private static int subSetCount(int[] arr, int sum, int index) {
		if(sum == 0) return 1;
		if(sum < 0 || index < 0) return 0;
		
		// exclude the coin
		int x = subSetCount(arr, sum-arr[index], index--);
		// include the coin
		int y = subSetCount(arr, sum, index--);
		return x+y;
	}

}

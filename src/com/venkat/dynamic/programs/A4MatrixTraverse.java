package com.venkat.dynamic.programs;

public class A4MatrixTraverse {

	public static void main(String[] args) {
		int[][] matrix = {
		        {1, 2, 3},
		        {4, 5, 6},
		        {7, 8, 9}
		    };
		
		int rows = matrix.length-1;
		int columns = matrix[0].length-1;
		System.out.println("Robot moves :: " + robotMoves(matrix, rows, columns));
		
		int[][] dp = {
		        {0, 0, 0},
		        {0, 0, 0},
		        {0, 0, 0}
		    };
		System.out.println("Robot moves :: " + robotMoves(matrix, rows, columns, matrix));
	}
	
	// Top Down Naive Recursion
	// TC O(2^m*n)
	// SC O(m*n)
	private static int robotMoves(int[][] grid, int row, int column) {
		if(row == 0 || column == 0) {
			return 1;
		}
		
		if(row < 0 || column < 0) {
			return 0;
		}
		
		return robotMoves(grid, row-1, column) + 
				robotMoves(grid, row, column-1);
	}
	
	// Top Down Recursion memoization
	// TC O(m*n)
	// SC O(m*n)
	private static int robotMoves(int[][] grid, int row, int column, int[][] dp) {
		if(row == 0 || column == 0) {
			dp[row][column] = 1;
			return dp[row][column];
		}
		if(row < 0 || column < 0) {
			return 0;
		}
		dp[row][column] = robotMoves(grid, row-1, column, dp) + 
				robotMoves(grid, row, column-1, dp);
		return dp[row][column];
	}

}

package com.task;

//Have the function SearchingChallenge (stzAzz) take the array of strings stored in strazz, which will be a 2D matrix of 0 and 1's, 
//and determine how many holes, or contiguous regions of O's, exist in the matrix. A contiguous region is one where there is a connected group of O's
//going in one or more of four directions: up, down, left, or right. For example: if strazz is ["10111", "10101", "11101", "11111"], then this looks 
//like the following matrix: 10 11 12 13 14 15 16 17 10111 10101 11101 11111 For the input above, your program should return 2 because there are two 
//separate contiguous regions of O's, which create "holes" in the matrix. You can assume the input will not be empty.

public class SearchingSolution {

	
	    public static int SearchingChallenge(String[] strArr) {
	        int rows = strArr.length;
	        int cols = strArr[0].length();
	        char[][] matrix = new char[rows][cols];
	        boolean[][] visited = new boolean[rows][cols];
	        int holeCount = 0;

	        // Convert input strings to a 2D char matrix
	        for (int i = 0; i < rows; i++) {
	            matrix[i] = strArr[i].toCharArray();
	        }

	        // DFS to find contiguous regions of 'O's
	        for (int i = 0; i < rows; i++) {
	            for (int j = 0; j < cols; j++) {
	                if (matrix[i][j] == 'O' && !visited[i][j]) {
	                    holeCount++;
	                    exploreRegion(matrix, visited, i, j);
	                }
	            }
	        }

	        return holeCount;
	    }

	    private static void exploreRegion(char[][] matrix, boolean[][] visited, int row, int col) {
	        int rows = matrix.length;
	        int cols = matrix[0].length;

	        // Check boundaries and whether cell is unvisited and an 'O'
	        if (row < 0 || row >= rows || col < 0 || col >= cols || visited[row][col] || matrix[row][col] != 'O') {
	            return;
	        }

	        visited[row][col] = true;

	        // Recursively explore adjacent cells
	        exploreRegion(matrix, visited, row - 1, col); // up
	        exploreRegion(matrix, visited, row + 1, col); // down
	        exploreRegion(matrix, visited, row, col - 1); // left
	        exploreRegion(matrix, visited, row, col + 1); // right
	    }

	    public static void main(String[] args) {
	        String[] strArr = {"10111", "10101", "11101", "11111"};
	        System.out.println(SearchingChallenge(strArr)); // Output: 2
	    }
	}

	


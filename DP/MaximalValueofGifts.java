/**
Maximal Value of Gifts
Question: A board has n*m cells, and there is a gift with some value (value is greater than 0) in every cell. 
You can get gifts starting from the top-left cell, and move right or down in each step, 
and finally reach the cell at the bottom-right cell. What’s the maximal value of gifts you can get from the board?


For example, the maximal value of gift from the board above is 53, and the path is highlighted in red.

http://codercareer.blogspot.com
*/

/*
Analysis: It is a typical problem about dynamic programming. 
Firstly let’s analyze it with recursion. A function f(i, j) is defined for the maximal value of gifts 
when reaching the cell (i, j). There are two possible cells before the cell (i, j) is reached: 
One is (i - 1, j), and the other is the cell (i, j-1). 
Therefore, f(i, j)= max(f(i-1, j), f(i, j-1)) + gift[i, j].

Even though it’s a recursive equation, it’s not a good idea to write code in recursion, 
because there might be many over-lapping sub-problems. A better solution is to solve is with iteration. 
A 2-D matrix is utilized, and the value in each cell (i, j) is the maximal value of gift when 
reaching the cell (i, j) on the board.

The iterative solution can be implemented in the following Java code:
*/

public static int getMaxValue(int[][] values) {
	int rows = values.length;
	int cols = values[0].length;
	int[][] maxValues = new int[rows][cols];

	for(int i = 0; i < rows; i++){
		for(int j = 0; j < cols; j++){
			int left = 0;
			int up = 0;

			if(i > 0){
				up = maxValues[i-1][j];
			}

			if(j > 0){
				left = maxValues[i][j-1];
			}

			maxValues[i][j] = Math.max(left, up) + values[i][j];
		}
	}
	return maxValues[rows - 1][cols - 1];
}

/*
Optimization

The maximal value of gifts when reaching the cell (i, j) depends on the cells (i-1, j) and (i, j-1) only, 
so it is not necessary to save the value of the cells in the rows i-2 and above. 
Therefore, we can replace the 2-D matrix with an array, as the following code shows:
*/

public static int getMaxValue(int[][] values) {
	int rows = values.length;
	int cols = values[0].length;

	int[] maxValues = new int[cols];
	for(int i = 0; i < rows; i++){
		for(int j = 0; j < cols; j++){
			int left = 0;
			int up = 0;

			if(i > 0){
				up = maxValues[j];
			}

			if(j > 0){
				left = maxValues[j - 1];
			}
			maxValues[j] = Math.max(left, up) + values[i][j];
		}
	}
	return maxValues[cols - 1];
}
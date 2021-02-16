
//https://www.youtube.com/watch?v=Sv9DK2C4rtc
//LeetCode 59: Spiral Matrix II - Interview Prep Ep 32
//https://leetcode.com/problems/spiral-matrix-ii/

class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
		if(n == 0){
			return matrix;
		}
		int top = 0;
		int bottom = n - 1;
		int left = 0;
		int right = n - 1;
		int num = 1;
		while(left <= right && top <= bottom){
			// reach the max top
			for(int j = left; j <= right; j++){
				matrix[top][j] = num++;
			}
			// go bottom
			top++;
			for(int i = top; i <= bottom; i++){
				matrix[i][right] = num++;
			}
			// go left
			right--;
			for(int j = right; j >= left; j--){
				matrix[bottom][j] = num++;
			}
			// go top
			bottom--;
			for(int i = bottom; i >= top; i--){
				matrix[i][left] = num++;
			}
			// go right
			left++;
		}
		return matrix;
    }
}

/*
Input: n = 3
Output: [[1,2,3],[8,9,4],[7,6,5]]
*/


//https://www.youtube.com/watch?v=gCciKhaK2v8
//LeetCode 48: Rotate Image | Rotate N*N Matrix | Rotate a Square - Interview Prep Ep 54
//https://leetcode.com/problems/rotate-image/

class Solution {
    public void rotate(int[][] matrix) {
        int n  = matrix.length;
		for(int i = 0; i < n/2; i++){
			for(int j = i; j < n-i-1; j++){
				//save the top
				int top = matrix[i][j];
				
				//move left to top
				matrix[i][j] = matrix[n -1 -j][i];
				
				//move bottom to left
				matrix[n -1 -j][i] = matrix[n -i -1][n -1 -j];
				
				//move right to bottom
				matrix[n -i -1][n -1 -j] = matrix[j][n - i -1];
				
				//move top to right
				matrix[j][n -i -1] = top;
			}
		}
    }
}

// Solution 2
class Solution {
    public void rotate(int[][] matrix) {
		int n = matrix.length;
		// Transpose
		for(int i = 0; i < n; i++){
			for(int j = i; j < n; j++){
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = tmp;
			}
		}
		
		// reverse each row
		for(int i = 0; i < n; i++){
			int start = 0;
			int end = n - 1;
			while(start < end){
				int tmp = matrix[i][start];
				matrix[i][start] = matrix[i][end];
				matrix[i][end] = tmp;
				start++;
				end--;
			}
		}
	}
}
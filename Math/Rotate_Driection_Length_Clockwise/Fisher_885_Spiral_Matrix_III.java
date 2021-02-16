
//https://www.youtube.com/watch?v=0qep3f9cqVs
//LeetCode 885: Spiral Matrix III - Interview Prep Ep 33
//https://leetcode.com/problems/spiral-matrix-iii/

class Solution {
    public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        int[][] matrix = new int[R*C][2];
		int i = 0;
		// r0 , c0 -> starting position facing east
		// 		N 
		// W 		 E
		// 		S
		matrix[i++] = new int[]{r0, c0};
		int len = 0;
		int d = 0;
		// 			{-1,0}
		// {0,-1}			{0,1}
		// 		    {1,0}
		int [] direcitons = new int[]{0, 1, 0, -1, 0};
		while(i < R*C){
			// when moving east or west incrase the length by one
			if(d == 0 || d == 2){
				len++;
			}
			for(int k = 0; k < len; k++){
				// movement
				r0 += direcitons[d];
				c0 += direcitons[d + 1];
				// check boundary
				if(r0 < R && r0 >= 0 && c0 < C && c0 >= 0){
					// if it is inside add to the result matrix
					matrix[i++] = new int[]{r0, c0};
				}
			}
			// control the direction
			d = ++d % 4;
		}
		return matrix;
    }
}

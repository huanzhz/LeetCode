
//https://www.youtube.com/watch?v=uYgoo8BdUAA
//LeetCode 54: Spiral Matrix - Interview Prep Ep 31
//https://leetcode.com/problems/spiral-matrix/

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length ==0){
			return new ArrayList();
		}
		int m = matrix.length;
		int n = matrix[0].length;
		int top = 0;
		int bottom = m - 1;
		int left = 0;
		int right = n - 1;
		List<Integer> result = new ArrayList();
		while(result.size() < m * n){
			// reach the max top
			for(int j = left; j <= right && result.size() < m * n; j++){
				result.add(matrix[top][j]);
			}
			// go bottom
			top++;
			for(int i = top; i <= bottom && result.size() < m * n; i++){
				result.add(matrix[i][right]);
			}
			// go left
			right--;
			for(int j = right; j >= left && result.size() < m * n; j--){
				result.add(matrix[bottom][j]);
			}
			// go top
			bottom--;
			for(int i = bottom; i >= top && result.size() < m * n; i--){
				result.add(matrix[i][left]);
			}
			// go right
			left++;
		}
		return result;
    }
}


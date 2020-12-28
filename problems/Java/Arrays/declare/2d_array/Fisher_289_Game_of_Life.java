
//https://www.youtube.com/watch?v=YZ-W5DrKPQ0
//LeetCode 289. Game of Life - Interview Prep Ep 80
//https://leetcode.com/problems/game-of-life/

class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
		int n = board[0].length;
		int [][] next = new int[m][n];
		// duplicate the board so can update simultaneously
		int [][] dirs = new int[][]{
			{-1, 0},
			{-1, 1},
			{0, 1},
			{1, 1},
			{1, 0},
			{1, -1},
			{0, -1},
			{-1, -1},
		};
		// loop through the double array
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				int liveCount = 0;
				for(int[] dir : dirs){
					int x = dir[0] + i;
					int y = dir[1] + j;
					// check the boundary of the board
					if(x >= 0 && x < m && y >= 0 && y < n && board[x][y] == 1){
						liveCount++;
					}
				}
				
				// Rule 4
				if(board[i][j] == 0 && liveCount == 3){
					next[i][j] = 1;
				} else if(board[i][j] == 1){
					// Rule 2
					if(liveCount == 2 || liveCount == 3){
						next[i][j] = 1;
					}
				}
			}
		}
		
		// Copy back to the original board
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				board[i][j] = next[i][j];
			}
		}
    }
}



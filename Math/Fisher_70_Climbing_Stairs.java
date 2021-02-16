
//https://www.youtube.com/watch?v=ZMNRb9TYiQM
//LeetCode 70. Climbing Stairs - Interview Prep Ep 72
//https://leetcode.com/problems/climbing-stairs/

class Solution {
    public int climbStairs(int n) {
        if(n == 1){
			return n;
		}
		int[] dp = new int[n + 1];
		dp[1] = 1;
		dp[2] = 2;
		for(int i = 3; i <= n; i++){
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[n];
    }
}

// O(1) for space complexity
class Solution {
    public int climbStairs(int n) {
        if(n == 1){
			return n;
		}
		int oneStep = 1;
		int twoStep = 2;
		for(int i = 3; i <= n; i++){
			int tmp = twoStep;
			twoStep = oneStep + twoStep;
			oneStep = tmp;
		}
		return twoStep;
    }
}

/*
Input: n = 2
Output: 2
Input: n = 3
Output: 3
*/


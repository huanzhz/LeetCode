
//https://www.youtube.com/watch?v=A-i2sxmBqAA
//LeetCode 1551. Minimum Operations to Make Array Equal - Interview Prep Ep 91
//https://leetcode.com/problems/minimum-operations-to-make-array-equal/

class Solution {
    public int minOperations(int n) {
        int min = 1;
		// given formula
		int max = 2 * (n - 1) + 1;
		// get the equal number
		int equalNumber = (min + max) / 2;
		// number of operations -> ops
		int ops = 0;
		for(int i = 0; i < n / 2; i++){
			// (2 * i + 1) given formula -> 1,3,5,7 ...
			ops += equalNumber - (2 * i + 1);
		}
		return ops;
    }
}
/*
Input: n = 3
Output: 2
Input: n = 6
Output: 9
*/



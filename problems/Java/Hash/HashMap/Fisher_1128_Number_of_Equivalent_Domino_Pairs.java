
//https://www.youtube.com/watch?v=7EpEEHAAxyw
//LeetCode 1128: Number of Equivalent Domino Pairs - Interview Prep Ep 18
//https://leetcode.com/problems/number-of-equivalent-domino-pairs/

class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int m = dominoes.length;
		Map<Integer, Integer> map = new HashMap();
		int count = 0;
		for( int[] pair : dominoes){
			int small = Math.min(pair[0], pair[1]);
			int big = Math.max(pair[0], pair[1]);
			
			// [1,2] [2,1] generate a key for each pair
			// 10 because the question got [i][j] <= 9
			int key = small * 10 + big;
			
			count += map.getOrDefault(key, 0);
			
			map.put(key, map.getOrDefault(key, 0) + 1);
		}
		return count;
    }
}


/*
Input: dominoes = [[1,2],[2,1],[3,4],[5,6]]
Output: 1
[1,2] [2,1] -> 1 pair
*/
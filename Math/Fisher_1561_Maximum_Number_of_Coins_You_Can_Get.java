
//https://www.youtube.com/watch?v=hPe9Z3TiUrA
//LeetCode 1561. Maximum Number of Coins You Can Get - Interview Prep Ep 92
//https://leetcode.com/problems/maximum-number-of-coins-you-can-get/

// get the second largest
class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
		int j = 0;
		int len = piles.length;
		int coins = 0;
		// start from last 2nd 
		for( int i = len - 2; i > 0; i -= 2){
			coins += piles[i];
			if(++j == len /3){
				return coins;
			}
		}
		return coins;
    }
}

/*
Input: piles = [2,4,1,2,7,8]
Output: 9
Input: piles = [2,4,5]
Output: 4
Input: piles = [9,8,7,6,5,1,2,3,4]
Output: 18	-> 8,6,4
*/

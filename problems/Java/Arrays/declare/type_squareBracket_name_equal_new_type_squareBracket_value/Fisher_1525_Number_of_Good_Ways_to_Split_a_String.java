
//https://www.youtube.com/watch?v=lRVpVUC5mQ4
//LeetCode 1525. Number of Good Ways to Split a String - Interview Prep Ep 84
//https://leetcode.com/problems/number-of-good-ways-to-split-a-string/

class Solution {
    public int numSplits(String s) {
        int goodSplits = 0;
		int[] left = new int[26];
		int[] right = new int[26];
		// set the character into the array of 0-25
		for(int i = 0; i < s.length(); i++){
			char c = s.charAt(i);
			right[c - 'a']++;
		}
		for(int i = 0; i < s.length(); i++){
			char c = s.charAt(i);
			// add to left array and remove from right array
			left[c - 'a']++;
			
			right[c - 'a']--;
			
			// get distinct character
			int distinctCharOnTheLeft = getDistinct(left);
			int distinctCharOnTheRight = getDistinct(right);
			
			// if both left and right side have the same distinct charcter
			if(distinctCharOnTheLeft == distinctCharOnTheRight){
				goodSplits++;
			}
		}
		return goodSplits;
    }
	
	int getDistinct(int[] count){
		int c = 0;
		for(int i : count){
			if(i != 0){
				c++;
			}
		}
		return c;
	}
}
/*
Input: s = "aacaba"
Output: 2
Input: s = "abcd"
Output: 1
Input: s = "aaaaa"
Output: 4
Input: s = "acbadbaada"
Output: 2
*/



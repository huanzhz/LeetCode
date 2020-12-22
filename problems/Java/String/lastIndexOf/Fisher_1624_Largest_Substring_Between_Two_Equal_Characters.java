
//https://www.youtube.com/watch?v=rfjeFs3JuYM
//LeetCode 1624. Largest Substring Between Two Equal Characters - Interview Prep Ep 101
//https://leetcode.com/problems/largest-substring-between-two-equal-characters/
//String.lastIndexOf(char)

class Solution{
	public int maxLengthBetweenEqualCharacters(String s){
		int maxLen = -1;
		for(int i =0; i < s.length(); i++){
			char c = s.charAt(i);
			int lastIndex = s.lastIndexOf(c);
			if(lastIndex != i){
				// -i -1 is to take the both end off
				maxLen = Math.max(maxLen, lastIndex - i - 1);
			}
		}
		return maxLen;
	}
}

/*
Input: s = "aa"
Output: 0
Input: s = "abca"
Output: 2
Input: s = "cbzxy"
Output: -1
Input: s = "cabbac"
Output: 4
*/


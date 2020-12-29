
//https://www.youtube.com/watch?v=iWenZCZEBIA
//LeetCode 139. Word Break - Interview Prep Ep 79
//https://leetcode.com/problems/word-break/

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
		boolean[] dp = new boolean[n + 1];
		
		// find the max length of the word in the dictionary
		int maxLen = 0;
		for(String word : wordDict){
			maxLen = Math.max(maxLen, word.length());
		}
		
		dp[0] = true;
		for(int i = 0; i <= n; i++){
			// start from the position of i instead of begining, to save time
			for( int j = i - 1; j >= 0; j--){
				// if the word is 6 length and maxlength in dictionary only 5 then no point to check on
				if(i - j > maxLen){
					continue;
				}
				// substring from [j] to [i]
				// found a word in the dictionary
				if(dp[j] && wordDict.contains(s.substring(j, i))){
					dp[i] = true;
					break;
				}
			}
		}
		return dp[n];
    }
}

/*
Input: s = "leetcode", wordDict = ["leet", "code"]
Output: true
Input: s = "applepenapple", wordDict = ["apple", "pen"]
Output: true
Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
Output: false
*/


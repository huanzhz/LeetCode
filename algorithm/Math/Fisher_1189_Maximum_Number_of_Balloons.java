
//https://www.youtube.com/watch?v=LGgMZC0vj5s
//LeetCode 1189: Maximum Number of Balloons - Interview Prep Ep 37
//https://leetcode.com/problems/maximum-number-of-balloons/

class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] count = new int[26];
		// count the b,a,l,o,n
		for(char c : text.toCharArray()){
			count[c - 'a']++;
		}
		return Math.min(count[1], Math.min(count[0], Math.min(count[11]/2, Math.min(count[14]/2, count[13]))));
    }
}

/*
Input: text = "nlaebolko"
Output: 1
Input: text = "loonbalxballpoon"
Output: 2
Input: text = "leetcode"
Output: 0
*/
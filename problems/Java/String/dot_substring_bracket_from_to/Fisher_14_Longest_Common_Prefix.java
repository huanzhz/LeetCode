
//https://www.youtube.com/watch?v=K1ps6d7YCy4
//LeetCode 14: Longest Common Prefix - Interview Prep Ep 19
//https://leetcode.com/problems/longest-common-prefix/

//horizontal solution
// "flower" -> "flowe" -> "flow" -> "flo" -> "fl" -> "f" -> ""
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0){
			return "";
		}
		String prefix = strs[0];
		for(int i = 1; i < strs.length; i++){
			// indexOf -> returns the index within this string of the first occurrence
			// https://www.geeksforgeeks.org/java-string-indexof/
			while(strs[i].indexOf(prefix) != 0){
				prefix = prefix.substring(0, prefix.length() - 1);
				if(prefix.length() == 0){
					return "";
				}
			}
		}
		return prefix;
		
    }
}

//vertical solution
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0){
			return "";
		}
		for(int i = 0; i < strs[0].length(); i++){
			char c = strs[0].charAt(i);// '0'
			for(int j = 1; j < strs.length; j++){// j = 2, i = 2
				if( i == strs[j].length() || c != strs[j].charAt(i)){
					//'o' != 'i'
					return strs[j].substring(0, i);
				}
			}
		}
		return strs[0];
    }
}

/*
Input: strs = ["flower","flow","flight"]
Output: "fl"

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
*/

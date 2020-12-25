
//https://www.youtube.com/watch?v=SJBDLYqrIsM
//LeetCode 1576. Replace All ?'s to Avoid Consecutive Repeating Characters - Interview Prep Ep 97
//https://leetcode.com/problems/replace-all-s-to-avoid-consecutive-repeating-characters/

class Solution {
    public String modifyString(String s) {
        char[] arr = s.toCharArray();
		for(int i = 0; i < arr.length; i++){
			// if there is a question mark
			if(arr[i] == '?'){
				// check for 3 characters [a|b|c]
				for(int j = 0; j < 3; j++){
					// check if there is a left neighbour which is [a|b|c]
					if(i > 0 && arr[i - 1] == 'a' + j){
						continue;
					} else if(i < arr.length - 1 && arr[i + 1] == 'a' + j){
						// check if there is a right neighbour which is [a|b|c]
						continue;
					} else {
						// safe to input into the question mark
						arr[i] = (char) ('a' + j);
						break;
					}
				}
			}
		}
		// valueOf
		// https://www.tutorialspoint.com/java/java_string_valueof.htm
		// This method returns the string representation
		return String.valueOf(arr);
    }
}

/*
Input: s = "?zs"
Output: "azs"
Input: s = "ubv?w"
Output: "ubvaw"
Input: s = "j?qg??b"
Output: "jaqgacb"
Input: s = "??yw?ipkj?"
Output: "acywaipkja"
*/
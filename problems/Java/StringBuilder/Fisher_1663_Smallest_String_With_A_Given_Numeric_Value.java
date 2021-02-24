
//https://www.youtube.com/watch?v=o3MRJfsoUrw
//LeetCode 1663. Smallest String With A Given Numeric Value - Interview Prep Ep 111
//https://leetcode.com/problems/smallest-string-with-a-given-numeric-value/

class Solution {
    public String getSmallestString(int n, int k) {
        StringBuilder sb = new StringBuilder();
		int balance = k - n;
		while(balance > 0){
			// get all the z
			if(balance > 25){
				balance -= 25;
				sb.append("z");
				n--;
			} else {
				// get remain 'a' to 'y'
				char str = (char) ('a' + balance);
				sb.append(str);
				n--;
				// get all others as 'a'
				while(n > 0){
					sb.append('a');
					n--;
				}
				break;
			}
		}
		return sb.reverse().toString();
    }
}

/*
Input: n = 3, k = 27
Output: "aay"
Explanation: The numeric value of the string is 1 + 1 + 25 = 27, and it is the smallest string with such a value and length equal to 3.
*/

//https://www.youtube.com/watch?v=34QYE5HAFy4
//LeetCode 1545. Find Kth Bit in Nth Binary String - Interview Prep Ep 90
//https://leetcode.com/problems/find-kth-bit-in-nth-binary-string/

//brute force solution
// Sn is formed as follows:
//S1 = "0"
//Si = Si-1 + "1" + reverse(invert(Si-1)) for i > 1
class Solution {
    public char findKthBit(int n, int k) {
        String[] strs = new String[n];
		// set first char to 0
		strs[0] = "0";
		for(int i = 1; i < n; i++){
			// call form string method
			strs[i] = formString(strs[i - 1]);
		}
		// after all the function get the 
		return strs[n - 1].charAt(k - 1);
    }
	
	private String formString(String str){
		return str + "1" + reverse(invert(str));
	}
	
	private String reverse(String str){
		return new StringBuilder(str).reverse().toString();
	}
	
	private String invert(String str){
		StringBuilder sb = new StringBuilder();
		for(char c : str.toCharArray()){
			if(c == '1'){
				sb.append('0');
			} else {
				sb.append('1');
			}
		}
		return sb.toString();
	}
}

/*
Input: n = 3, k = 1
Output: "0"
Input: n = 4, k = 11
Output: "1"
Input: n = 1, k = 1
Output: "0"
Input: n = 2, k = 3
Output: "1"
*/


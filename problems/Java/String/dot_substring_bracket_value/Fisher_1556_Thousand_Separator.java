
//https://www.youtube.com/watch?v=re2BnNbg598
//LeetCode 1556. Thousand Separator - Interview Prep Ep 93
//https://leetcode.com/problems/thousand-separator/

class Solution {
    public String thousandSeparator(int n) {
        String str = Integer.toString(n);
		StringBuilder sb = new StringBuilder();
		// minus 1 because array start from 0
		// start from the right side, for example 987: 7 will go first 
		for(int i = str.length() - 1, j = 1; i >= 0; i--, j++){
			sb.append(str.charAt(i));
			j++;
			if(j % 3 == 0){
				sb.append(".");
			}
		}
		// 789. 0> reverse .987
		String result = sb.reverse().toString();
		// cut off the first dot
		if(result.charAt(0) == '.'){
			result = result.substring(1);
		}
		return result;
    }
}

/*
Input: n = 987
Output: "987"
Input: n = 1234
Output: "1.234"
Input: n = 123456789
Output: "123.456.789"
Input: n = 0
Output: "0"
*/



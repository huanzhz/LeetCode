
//LeetCode 344: Reverse String - Interview Prep Ep 56
//https://www.youtube.com/watch?v=P68JPXtFyYg
//https://leetcode.com/problems/reverse-string/

// 2 pointer solution
class Solution {
    public void reverseString(char[] s) {
        int i = 0;
		int j = s.length - 1;
		// when they do not meet each other
		while(i < j){
			char tmp = s[i];
			s[i] = s[j];
			s[j] = tmp;
			i++;
			j--;
		}
    }
}


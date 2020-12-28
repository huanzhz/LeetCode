
//https://www.youtube.com/watch?v=Q-ycCXbUOck
//LeetCode 1544. Make The String Great - Interview Prep Ep 89
//https://leetcode.com/problems/make-the-string-great/

class Solution {
    public String makeGood(String s) {
        Stack<Character> stack = new Stack();
		for(int i = 0; i < s.length(); i++){
			char c = s.charAt(i);
			// check the incoming is similar to the peek character
			if(stack.isEmpty()){
				stack.add(c);
			} else {
				// change both character to lower case to see if they are the same
				if(Character.toLowerCase(stack.peek()) == Character.toLowerCase(c)){
					// a A then pop || A a then pop
					if(Character.isLowerCase(stack.peek()) == Character.isUpperCase(c)){
						stack.pop();
					} else if (Character.isLowerCase(c) == Character.isUpperCase(stack.peek())){
						stack.pop();
					} else {
						stack.add(c);
					}
				} else {
					stack.add(c);
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		while(!stack.isEmpty()){
			sb.append(stack.pop());
		}
		// pop will get the last character first hence we need reverse it.
		return sb.reverse().toString();
    }
}

/*
Input: s = "leEeetcode"
Output: "leetcode"
Input: s = "abBAcC"
Output: ""
*/





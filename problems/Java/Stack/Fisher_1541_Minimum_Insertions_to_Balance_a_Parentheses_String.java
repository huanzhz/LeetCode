
//https://www.youtube.com/watch?v=PEKAlnmbBCc
//LeetCode 1541. Minimum Insertions to Balance a Parentheses String - Interview Prep Ep 88
//https://leetcode.com/problems/minimum-insertions-to-balance-a-parentheses-string/

class Solution {
    public int minInsertions(String s) {
        Stack<Character> stack = new Stack();
		int insertionsNeeded = 0;
		for(int i = 0; i < s.length(); i++){
			char c = s.charAt(i);
			// starting with paratheses = '('
			if(c == '('){
				if(stack.isEmpty()){
					stack.add(c);
				} else {
					// case left and right -> current stack ()
					// final (
					// stack peek -> retrieve or fetch the first element of the Stack or the element present at the top of the Stack.
					// https://www.geeksforgeeks.org/stack-peek-method-in-java/
					if(stack.peek() != '('){
						insertionsNeeded++;
						stack.pop();
						stack.pop();
					}
					stack.add(c);
				}
			} else {
				// starting with paratheses = ')'
				// check if stack is empty
				if(stack.isEmpty()){
					insertionsNeeded++;
					// add ( to counter it
					stack.add('(');
					stack.add(c);
				} else {
					// check if the current top stack is '('
					if(stack.peek() == '('){
						stack.add(c);
					} else {
						stack.pop();
						stack.pop();
					}
				}
			}
		}
		// check if the stack is empty
		if(stack.isEmpty()){
			return insertionsNeeded;
		} else {
			while(!stack.isEmpty()){
				char c = stack.pop();
				// only one ( which need add two ))
				if(c == '('){
					insertionsNeeded += 2;
				} else {
					// two right )) which need one (
					insertionsNeeded++;
					stack.pop();
				}
			}
			return insertionsNeeded;
		}
    }
}

/*
Input: s = "(()))"
Output: 1
Input: s = "())"
Output: 0
Input: s = "))())("
Output: 3
Input: s = "(((((("
Output: 12
Input: s = ")))))))"
Output: 5
*/


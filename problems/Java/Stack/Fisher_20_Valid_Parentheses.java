
//https://www.youtube.com/watch?v=eBbg5pnq5Zg
//LeetCode 20: Valid Parentheses - Interview Prep Ep 7
//https://leetcode.com/problems/valid-parentheses/


// Time: O(n)
// Space: O(n)
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        for(char c : s.toCharArray()){
            if(c == '('){
                stack.push(')');
            }else if(c == '['){
                stack.push(']');
            }else if (c == '{'){
                stack.push('}');
            } else if (stack.isEmpty() || stack.pop() != c){
                // if the pop is not equal to the closing return false
                return false;
            }
        }
        return stack.isEmpty();
    }
}



/*
Input: s = "()"
Output: true
Input: s = "()[]{}"
Output: true
Input: s = "([)]"
Output: false
*/


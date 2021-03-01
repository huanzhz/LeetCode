
//https://www.youtube.com/watch?v=WPBTYmvcHXs
//LeetCode 509: Fibonacci Number - Interview Prep Ep 13
//https://leetcode.com/problems/fibonacci-number/

class Solution {
    public int fib(int n) {
        if(N < 2){
            return N;
        }
        int a = 0;
        int b = 1;
        while(N-- > 1){
            int sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }
}

/*
Input: n = 2
Output: 1
Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.

Input: n = 3
Output: 2
Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
*/
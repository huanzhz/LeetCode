
//https://www.youtube.com/watch?v=GBJFxSD3B_s
//LeetCode 1673. Find the Most Competitive Subsequence - Interview Prep Ep 112
//https://leetcode.com/problems/find-the-most-competitive-subsequence/

class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        Stack<Integer> stack = new Stack();
        for(int i = 0; i < nums.length; i++){
            // pop if found a smaller number than the top of the stack
            // make the smallest number to the base/first
            while(!stack.isEmpty() && nums[i] < stack.peek() && (stack.size() + nums.length - i) > k){
                stack.pop();
            }
            // fullfill the length of number k
            if(stack.size() < k){
                stack.push(nums[i]);
            }
        }
        int[] result = new int[k];
        // turn stack into array
        // put the largest number at the back
        for(int i = k - 1; i >= 0; i--){
            result[i] = stack.pop();
        }
        return result;
    }
}

/*
Input: nums = [3,5,2,6], k = 2
Output: [2,6]
Explanation: Among the set of every possible subsequence: 
{[3,5], [3,2], [3,6], [5,2], [5,6], [2,6]}, [2,6] is the most competitive.

Input: nums = [2,4,3,3,5,4,9,6], k = 4
Output: [2,3,3,4]
*/


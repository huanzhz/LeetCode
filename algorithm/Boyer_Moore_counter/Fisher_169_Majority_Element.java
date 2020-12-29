
//https://www.youtube.com/watch?v=M1IL4hz0QrE
//LeetCode 169. Majority Element - Interview Prep Ep 73 | Boyer–Moore majority vote algorithm
//https://leetcode.com/problems/majority-element/

// need the majority element exist
class Solution {
    public int majorityElement(int[] nums) {
        int counter = 1;
		int candidate = nums[0];
		for(int i = 1; i < nums.length; i++){
			if(counter == 0){
				candidate = nums[i];
			}
			if(nums[i] == candidate){
				counter++;
			} else {
				counter--;
			}
		}
		return candidate;
    }
}

/*
Input: [3,2,3]
Output: 3
Input: [2,2,1,1,1,2,2]
Output: 2
*/



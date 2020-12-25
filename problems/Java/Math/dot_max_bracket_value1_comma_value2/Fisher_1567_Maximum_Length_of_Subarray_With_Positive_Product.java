
//https://www.youtube.com/watch?v=bFer5PdsgpY
//LeetCode 1567. Maximum Length of Subarray With Positive Product - Interview Prep Ep 96
//https://leetcode.com/problems/maximum-length-of-subarray-with-positive-product/

class Solution {
    public int getMaxLen(int[] nums) {
        int max = 0;
		for(int i = 0; i < nums.length; i++){
			// if max is 4 and remain left 3 element, return value as there is no way to reach another max value
			if(nums.length - i <= max){
				return max;
			}
			// if starting number is no zero
			if(nums[i] != 0){
				// if first number is negative set to 1
				int negatives = nums[i] > 0 ? 0 : 1;
				// update the max number, number greater than 0 set to 1
				max = Math.max(max, nums[i] > 0 ? 1 : 0);
				// find out the negatives length last 
				for(int j = i + 1; j < nums.length; j++){
					if(nums[j] < 0){
						negatives++;
					} else if(nums[j] == 0){
						break;
					}
					if(negatives % 2 == 0){
						// update the total number of element
						max = Math.max(max, j - i + 1);
					}
				}
			}
		}
		return max;
    }
}
/*
Input: nums = [1,-2,-3,4]
Output: 4
Input: nums = [0,1,-2,-3,-4]
Output: 3
Input: nums = [-1,-2,-3,0,1]
Output: 2
Input: nums = [-1,2]
Output: 1
Input: nums = [1,2,3,5,-6,4,0,10]
Output: 4
*/


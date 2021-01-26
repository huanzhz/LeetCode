
//https://www.youtube.com/watch?v=nRKZC2JF7LU
//LeetCode 26: Remove Duplicates from Sorted Array - Interview Prep Ep 45
//https://leetcode.com/problems/remove-duplicates-from-sorted-array/

// 2 point tactic, slow and fast
class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
		for(int j = 1; j < nums.length; j++){
			if(nums[i] != nums[j]){
				nums[++i] = nums[j];
			}
		}
		return i + 1;
    }
}

/*
Input: nums = [1,1,2]
Output: 2, nums = [1,2]
Input: nums = [0,0,1,1,1,2,2,3,3,4]
Output: 5, nums = [0,1,2,3,4]
*/
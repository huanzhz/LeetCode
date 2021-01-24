
//https://www.youtube.com/watch?v=-t2cdVs9cKk
//LeetCode 1150: Check If a Number Is Majority Element in a Sorted Array - Interview Prep Ep 48
//https://leetcode.com/problems/check-if-a-number-is-majority-element-in-a-sorted-array/

class Solution {
	//Time: O(logn)
	//Space: O(1)
	public boolean isMajorityElement(int[] nums, int target){
		int firstIndex = binarySearch(nums, target);
		int lastIndex = firstIndex + nums.length / 2;
		// return true or false
		return lastIndex < nums.length && nums[lastIndex] == target;
	}
	
	// find first occurance of the target
	private in binarySearch(int[] nums, int target){
		int left = 0;
		int right = nums.length - 1;
		while(left < right){
			int mid = left + (right - left)/2;
			if(nums[mid] < target){
				left = mid + 1;
			} else if(nums[mid] >= target){
				right = mid;
			}
		}
		return left;
	}
}

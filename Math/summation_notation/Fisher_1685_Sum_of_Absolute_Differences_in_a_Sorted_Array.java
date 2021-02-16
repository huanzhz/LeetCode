
//https://www.youtube.com/watch?v=WYe644djV30
//LeetCode 1685. Sum of Absolute Differences in a Sorted Array - Interview Prep Ep 113
//https://leetcode.com/problems/sum-of-absolute-differences-in-a-sorted-array/

// o(n^2) to o(n)
// (n - i - 1)
class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int len = nums.length;
		int[] preSums = new int[len];
		for(int i = 1; i < len; i++){
			preSums[i] = preSums[i - 1] + nums[i - 1];
		}
		int[] postSums = new int[len];
		for(int i = len - 2; i >= 0; i--){
			postSums[i] = postSums[i + 1] + nums[i + 1];
		}
		int[] result = new int[len];
		for(int i = 0; i < len; i++){
			// find the math patterns
			result[i] = i * nums[i] - (len - i - 1) * nums[i] - preSums[i] + postSums[i];
		}
		return result;
    }
}
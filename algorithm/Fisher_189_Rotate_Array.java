
//https://www.youtube.com/watch?v=lTHTR_jsqAQ
//LeetCode 189: Rotate Array - Interview Prep Ep 52
//https://leetcode.com/problems/rotate-array/

class Solution {
	//brute force:
	// Time: O(n*k)
	// Space: O(1)
	
	//Use extra array:
	// Time: O(n)
	// Space: O(n)
    public void rotate(int[] nums, int k) {
        int len = nums.length;
		int[] copy = new int[len];
		// find the correct position using an extra array
		for(int i = 0; i < len; i++){
			copy[(i + k) % len] = nums[i];
		}
		// copy the correct position back to original array
		for(int i = 0; i < len; i++){
			nums[i] = copy[i];
		}
    }
}

// Solution 2
class Solution {
	// Time: O(n)
	// Space: O(1)
	public void rotate(int[] nums, int k) {
		int len = nums.length;
		k %= len;
		reverse(nums, 0, len - 1);
		reverse(nums, 0, k - 1);
		reverse(nums, k, len - 1);
	}
	
	private void reverse(int[] nums, int start, int end){
		while(start < end){
			int tmp = nums[start];
			nums[start] = nums[end];
			nums[end] = tmp;
			start++;
			end--;
		}
	}
}


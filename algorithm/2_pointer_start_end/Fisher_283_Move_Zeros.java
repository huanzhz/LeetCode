
//https://www.youtube.com/watch?v=39VJV4KVyi8
//LeetCode 283: Move Zeroes - Interview Prep Ep 53
//https://leetcode.com/problems/move-zeroes/

class Solution {
    public void moveZeroes(int[] nums) {
        for(int i = 0, j = 0; i < nums.length && j < nums.length; j++){
			if(nums[j] != 0){
				// put the ending 0 into temp
				int tmp = nums[i];
				// set the number into ending 0 position and incrase i by 1
				// assign then increase the i
				nums[i++] = nums[j];
				// move the 0 in temp to the front
				nums[j] = tmp;
			}
		}
    }
}


//https://www.youtube.com/watch?v=jeim_j8VdiM
//LeetCode 15: 3Sum - Interview Prep Ep 20
//https://leetcode.com/problems/3sum/


class Solution {
	//O(n^2)
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList();
		for(int i = 0; i < nums.length - 2; i++){
			//{-1, -1, -1, 0, 1, 2}
			if(i > 0 && nums[i - 1] == nums[i]){
				continue;
			}
			int left = i + 1;
			int right = nums.length - 1;
			while(left < right){
				int sum = nums[i] + nums[left] + nums[right];
				if(sum == 0){
					// {-1, -1, 0, 0, 1, 1, 1, 2, 2, 3, 4, 4, 4}
					result.add(Arrays.asList(nums[i], nums[left], nums[right]));
					
					// 2 pointer
					while(left < right && nums[left] == nums[left+1]){
						left++;
					}
					while(left < right && nums[right] == nums[right - 1]){	
						right--;
					}
					left++;
					right--;
				}else if(sum > 0){
					right--;
				}else{
					left++;
				}
			}
		}
		return result;
    }
}


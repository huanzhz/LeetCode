
//https://www.youtube.com/watch?v=SFMCxqSeM94
//LeetCode 217 & 219: Contains Duplicate I & II - Interview Prep Ep 46
//https://leetcode.com/problems/contains-duplicate-ii/

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet();
		for(int i = 0; i< nums.length; i++){
			if(!set.add(nums[i])){
				return true;
			}
			if(set.size() > k){
				set.remove(nums[i - k]);
			}
		}
		return false;
    }
}



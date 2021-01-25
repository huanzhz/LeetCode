
//https://www.youtube.com/watch?v=SFMCxqSeM94
//LeetCode 217 & 219: Contains Duplicate I & II - Interview Prep Ep 46
//https://leetcode.com/problems/contains-duplicate/

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet();
		for(int num : nums){
			if(!set.add(num)){
				return true;
			}
		}
		return false;
    }
}


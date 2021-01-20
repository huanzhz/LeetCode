//https://www.youtube.com/watch?v=XxStWmfXJRs
//LeetCode 349: Intersection of Two Arrays - Interview Prep Ep 49
//https://leetcode.com/problems/intersection-of-two-arrays/

// sort then binary search
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		Set<Integer> intersect = new HashSet();
		for(int num : nums2){
			if(find(num, nums1)){
				intersect.add(num);
			}
		}
		int[] result = new int[intersect.size()];
		int i = 0;
		for(int num : intersect){
			result[i++] = num;
		}
		return result;
	}
	
	private boolean find(int target, int[] nums){
		int left = 0;
		int right = nums.length - 1;
		while(left <= right){
			int mid = left + (right - left)/2;
			if(nums[mid] == target){
				return true;
			} else if (nums[mid] > target){
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return false;
	}
}
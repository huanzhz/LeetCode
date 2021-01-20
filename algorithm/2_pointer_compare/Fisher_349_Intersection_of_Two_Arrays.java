
//https://www.youtube.com/watch?v=XxStWmfXJRs
//LeetCode 349: Intersection of Two Arrays - Interview Prep Ep 49
//https://leetcode.com/problems/intersection-of-two-arrays/

// 2 pointers compare
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		int i = 0;
		int j = 0;
		Set<Integer> intersect = new HashSet();
		while( i < nums1.length && j < nums2.length){
			if(nums1[i] == nums2[j]){
				intersect.add(nums1[i]);
				i++;
				j++;
			} else if (nums1[i] < nums2[j]){
				i++;
			} else {
				j++;
			}
		}
		
		int[] result = new int[intersect.size()];
		int k = 0;
		for(int num : intersect){
			result[k++] = num;
		}
		return result;
	}
}



//https://www.youtube.com/watch?v=lKuK69-hMcc
//LeetCode 350: Intersection of Two Arrays II - Interview Prep Ep 50
//https://leetcode.com/problems/intersection-of-two-arrays-ii/

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
		// get the shorter array
        if(nums1.length > nums2.length){
			return intersect(nums2, nums1);
		}
		Map<Integer, Integer> map = new HashMap();
		for(int num : nums1){
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		
		// if the number exist in the longer array, we add it to the list
		List<Integer> list = new ArrayList();
		for(int num : nums2){
			int count = map.getOrDefault(num, 0);
			if(count > 0){
				list.add(num);
				map.put(num, count - 1);
			}
		}
		
		// set the list to the result array 
		int[] result = new int[list.size()];
		int i = 0;
		for(int num : list){
			result[i++] = num;
		}
		return result;
    }
}

//Solution 2
class Solution {
	//Time: O(mlogm + nlogn)
	//Space: O(1)
    public int[] intersect(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		int i = 0;
		int j = 0;
		List<Integer> list = new ArrayList();
		while( i < nums1.length && j < nums2.length){
			// check if both number is the same, then add to the result list
			if(nums1[i] == nums2[j]){
				list.add(nums1[i]);
				i++;
				j++;
			} else if(nums1[i] < nums2[j]){
				i++;
			} else {
				j++;
			}
		}
		
		int[] result = new int[list.size()];
		int k = 0;
		for(int num : list){
			result[k++] = num;
		}
		return result;
	}
}


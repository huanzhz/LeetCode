//https://www.youtube.com/watch?v=XxStWmfXJRs
//LeetCode 349: Intersection of Two Arrays - Interview Prep Ep 49
//https://leetcode.com/problems/intersection-of-two-arrays/

class Solution {
	//Time : O(n+m) an average, O(n*m) worst case
	//Space : O(n+m)
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet();
		for(int num : nums1){
			set1.add(num);
		}
		
		Set<Integer> set2 = new HashSet();
		for(int num : nums2){
			set2.add(num);
		}
		
		//https://www.geeksforgeeks.org/set-retainall-method-in-java-with-example/#:~:text=The%20retainAll()%20method%20of,contained%20in%20the%20specified%20collection.&text=Parameters%3A%20This%20method%20takes%20collection,be%20retained%20from%20this%20set.
		// Removing elements from arrset 
        // specified in arrset2 
        // using retainAll() method
		set1.retainAll(set2);
		
		int[] result = new int[set1.size()];
		int i = 0;
		for(int num : set1){
			result[i++] = num;
		}
		return result;
    }
}

/*
Set before retainAll() operation : [1, 2, 3, 4, 5]
Collection Elements to be retained : [1, 2, 3]
Set after retainAll() operation : [1, 2, 3]
*/

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet();
		for(int num : nums1){
			set1.add(num);
		}
		
		Set<Integer> intersect = new HashSet();
		for(int num : nums2){
			if(set1.contains(num)){	
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
}
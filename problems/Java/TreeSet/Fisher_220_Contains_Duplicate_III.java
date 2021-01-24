
//https://www.youtube.com/watch?v=Cu7g9ovYHNI
//LeetCode 220: Contains Duplicate III - Interview Prep Ep 47
//https://leetcode.com/problems/contains-duplicate-iii/

class Solution {
    //Tree: O(nlog(min(n,k)))
	//Space: O(min(n, k))
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        // https://www.geeksforgeeks.org/treeset-in-java-with-examples/#:~:text=TreeSet%20is%20one%20of%20the,an%20explicit%20comparator%20is%20provided.
		// Elements are added using add() method 
		// Duplicates will not get insert 
		// Elements get stored in default natural 
        // Sorting Order(Ascending)
		TreeSet<Long> set = new TreeSet();
		for(int i = 0; i < nums.length; i++){
			// https://www.geeksforgeeks.org/treeset-floor-method-in-java-with-examples/
			// maximum value less than t
			// nums[i] = 25 , in the tree-> got 10, 20, 30, 40
			// 20 will be picked
			Long floor = set.floor((long) nums[i]);
			if(floor != null && nums[i] - floor <= t){
				return true;
			}
			
			// https://www.geeksforgeeks.org/treeset-ceiling-method-in-java-with-examples/
			// minimum value less than t
			// nums[i] = 25 , in the tree-> got 10, 20, 30, 40
			// 30 will be picked
			Long ceiling = set.ceiling((long) nums[i]);
			if(ceiling != null && ceiling - nums[i] <= t){
				return true;
			}
			
			// add the nums to the set
			set.add((long) nums[i]);
			// remove the first number of the array
			if(set.size() > k){
				set.remove((long) nums[i - k]);
			}
		}
		return false;
    }
}

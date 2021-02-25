
//https://www.youtube.com/watch?v=_NYimlZY1PE
//LeetCode 1207: Unique Number of Occurrences - Interview Prep Ep 17
//https://leetcode.com/problems/unique-number-of-occurrences/

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap();
		for(int num : arr){
			// find the count of each number
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		Set<Integer> set = new HashSet();
		// no dulpicate
		for(int key : map.keySet()){
			// if there is same size of the number return false
			if(!set.add(map.get(key))){
				return false;
			}
		}
		return true;
    }
}

/*
Input: arr = [1,2,2,1,1,3]
Output: true
Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same number of occurrences.

Input: arr = [1,2]
Output: false
*/


//https://www.youtube.com/watch?v=Fecpt1YZlCs
//LeetCode 1133: Largest Unique Number - Interview Prep Ep 41
//https://leetcode.com/problems/largest-unique-number/

class Solution{
	public int largestUniqueNumber(int[] A){
		Map<Integer, Integer> map = new HashMap();
		// put every number into the hashmap
		for(int num : A){
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		int max = -1;
		// keyset -> get the array of the num, <num, count>
		// https://www.geeksforgeeks.org/hashmap-keyset-method-in-java/
		for(int key : map.keySet()){
			// check the count is equal to 1
			if(map.get(key) == 1){
				// get the max value
				max = Math.max(max, key);
			}
		}
		return max;
	}
}

class Solution{
	public int largestUniqueNumber(int[] A){
		int[] counts = new int[1001];
		for(int num : A){
			counts[num]++;
		}
		for(int i = 1000; i >= 0; i--){
			if(counts[i] == 1){
				return i;
			}
		}
		return -1;
	}
}




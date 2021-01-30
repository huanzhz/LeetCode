
//https://www.youtube.com/watch?v=Fecpt1YZlCs
//LeetCode 1133: Largest Unique Number - Interview Prep Ep 41
//https://leetcode.com/problems/largest-unique-number/

class Solution{
	public int largestUniqueNumber(int[] A){
		// sort in decending order when is added
		TreeMap<Integer, Integer> map = new TreeMap<>((a,b) -> b - a);
		// put every number into the treemap
		for(int num : A){
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		for(int key : map.keySet()){
			// check the count is equal to 1
			if(map.get(key) == 1){
				return key
			}
		}
		return -1;
	}
}
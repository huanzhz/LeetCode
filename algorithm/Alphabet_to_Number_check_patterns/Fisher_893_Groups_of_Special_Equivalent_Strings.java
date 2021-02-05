
//https://www.youtube.com/watch?v=tbtXPKkA2Zw
//LeetCode 893: Groups of Special Equivalent Strings - Interview Prep Ep 36
//https://leetcode.com/problems/groups-of-special-equivalent-strings/

class Solution {
    public int numSpecialEquivGroups(String[] A) {
		// set to prevent dulpicate
        Set<String> set = new HashSet();
		for(String str : A){
			// changing alphabet to integer patterns 0 - 25
			int[] odd = new int[26];
			int[] even = new int[26];
			for(int i = 0; i < str.length() ; i++){
				if(i % 2 == 0){
					even[str.charAt(i) - 'a']++;
				}else{
					odd[str.charAt(i) - 'a']++;
				}
			}
			//https://www.geeksforgeeks.org/arrays-tostring-in-java-with-examples/
			// get the string patterns
			// 1,2,3,4
			String key = Arrays.toString(odd) + Arrays.toString(even);
			set.add(key);
		}
		return set.size();
    }
}

/*
Input: ["abcd","cdab","cbad","xyzz","zzxy","zzyx"]
Output: 3
Explanation: 
One group is ["abcd", "cdab", "cbad"], since they are all pairwise special equivalent, and none of the other strings are all pairwise special equivalent to these.

The other two groups are ["xyzz", "zzxy"] and ["zzyx"].  Note that in particular, "zzxy" is not special equivalent to "zzyx".


Input: ["abc","acb","bac","bca","cab","cba"]
Output: 3
*/


//https://www.youtube.com/watch?v=aJAV_VgmjdE
//LeetCode 1566. Detect Pattern of Length M Repeated K or More Times - Interview Prep Ep 95
//https://leetcode.com/problems/detect-pattern-of-length-m-repeated-k-or-more-times/

class Solution {
	//{2, 2, 1, 2, 2, 1, 1, 1, 2, 1}, 2, 2
    public boolean containsPattern(int[] arr, int m, int k) {
        for(int i = 0; i < arr.length - m; i++){
			// java api that copy an array 
			// public static short[] copyOfRange(short[] original, int from, int to)
			// https://www.tutorialspoint.com/java/util/arrays_copyofrange_short.htm
			int[] pattern = Arrays.copyOfRange(arr, i, i + m);
			// match consecutive
			int times = 1;
			// increase by length of m
			for(int j = i + m; j < arr.length; j += m){
				// next consecutive array
				int[] candidate = Arrays.copyOfRange(arr, j, j + m);
				// find out that they are consecutive or not
				if(Arrays.equals(pattern, candidate)){
					// count how many of this patterns
					times++;
					if(times == k){
						return true;
					}
				} else {
					break;
				}
			}
		}
		return false;
    }
}

/*
Input: arr = [1,2,4,4,4,4], m = 1, k = 3
Output: true
Input: arr = [1,2,1,2,1,1,1,3], m = 2, k = 2
Output: true
Input: arr = [1,2,1,2,1,3], m = 2, k = 3
Output: false
Input: arr = [1,2,3,1,2], m = 2, k = 2
Output: false
Input: arr = [2,2,2,2], m = 2, k = 3
Output: false
*/



//https://www.youtube.com/watch?v=Q0WKzdpR74o
//LeetCode 954. Array of Doubled Pairs - Interview Prep Ep 77
//https://leetcode.com/problems/array-of-doubled-pairs/

class Solution {
    public boolean canReorderDoubled(int[] A) {
        Map<Integer, Integer> map = new HashMap();
		// set the number into the hashmap and count how many of them
		for(int num : A){
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		Integer[] B = new Integer[A.length];
		for(int i = 0; i < A.length; i++){
			B[i] = A[i];
		}
		// sort the array by absolute value
		Arrays.sort(B, Comparator.comparingInt(Math::abs));
		for(int num : B){
			// if the number value is zero, move on to next number
			if(map.get(num) == 0){
				continue;
			}
			// if the current number next double is not available return false,
			// eample-> current (2,1) , (4,1) should available.
			if(map.getOrDefault(2 * num, 0) <= 0){
				return false;
			}
			// decrease the value in hashmap by one in both number
			// example -> (2,1) (4,1) become (2,0),(4,0)
			map.put(2 * num, map.get(2 * num) - 1);
			map.put(num, map.get(num) - 1);
		}
		return true;
    }
}

/*
Input: A = [3,1,3,6]
Output: false
Input: A = [2,1,2,6]
Output: false
Input: A = [4,-2,2,-4]
Output: true
Input: A = [1,2,4,16,8,4]
Output: false
*/
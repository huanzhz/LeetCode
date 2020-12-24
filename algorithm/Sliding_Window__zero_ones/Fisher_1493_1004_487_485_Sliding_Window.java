
//https://www.youtube.com/watch?v=nKhteIRZ2Ok
//Sliding Window LeetCode 1493, 1004, 487, 485 - Interview Prep 82
//https://leetcode.com/problems/max-consecutive-ones-iii/

// 1004
class Solution{
	public int longestOnes(int[] A, int K){
		int result = 0;
		for(int i = 0,j = 0; j < A.length; j++){
			if(A[j] == 0){
				K--;
			}
			
			while(K < 0){
				if(A[i] == 0){
					K++;
				}
				i++;
			}
			result = Math.max(result, j - i + 1);
		}
		return result;
	}
}
/*
Input: A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
Output: 6
Input: A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
Output: 10
*/

//https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/
//1493
class Solution {
    public int longestSubarray(int[] A) {
        int result = 0;
        int K = 1;
		for(int i = 0,j = 0; j < A.length; j++){
			if(A[j] == 0){
				K--;
			}
			
			while(K < 0){
				if(A[i] == 0){
					K++;
				}
				i++;
			}
			result = Math.max(result, j - i);
		}
		return result;
    }
}
/*
Input: nums = [1,1,0,1]
Output: 3
Input: nums = [0,1,1,1,0,1,1,0,1]
Output: 5
*/

//https://leetcode.com/problems/max-consecutive-ones/
//485
class Solution {
    public int findMaxConsecutiveOnes(int[] A) {
        int result = 0;
        int K = 0;
		for(int i = 0,j = 0; j < A.length; j++){
			if(A[j] == 0){
				K--;
			}
			
			while(K < 0){
				if(A[i] == 0){
					K++;
				}
				i++;
			}
			result = Math.max(result, j - i + 1);
		}
		return result;
    }
}
/*
Input: [1,1,0,1,1,1]
Output: 3
*/

//subscribe
//https://leetcode.com/problems/max-consecutive-ones-ii/
//487
class Solution{
	public int findMaxConsecutiveOnes(int[] A){
		int result = 0;
        int K = 1;
		for(int i = 0,j = 0; j < A.length; j++){
			if(A[j] == 0){
				K--;
			}
			
			while(K < 0){
				if(A[i] == 0){
					K++;
				}
				i++;
			}
			result = Math.max(result, j - i + 1);
		}
		return result;
	}
}



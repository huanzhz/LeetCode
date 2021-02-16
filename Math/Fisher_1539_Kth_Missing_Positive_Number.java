
//https://www.youtube.com/watch?v=p0P1JNHAB-c
//LeetCode 1539. Kth Missing Positive Number - Interview Prep Ep 87
//https://leetcode.com/problems/kth-missing-positive-number/

class Solution {
	//case 1: arr: [1, 2, 3], k = 2, result = 5
	//case 2: arr: [3, 4, 5], k = 2, result = 2
	//case 3: arr: [3, 4, 5, 9], k = 3, result = 6
	// save memory tactic
    public int findKthPositive(int[] arr, int k) {
        int missed = 0;
		for(int i = 0; i < arr.length; i++){
			if(i == 0){
				// case 2
				// -1 to not count the current number [3] -> 1 and 2 is missing only 
				missed += arr[0] - 1;
				// if the first number is start at 3 and (k is 3 or 2) then k is the answer
				if(missed >= k){
					return k;
				}
			} else {
				// case 3
				// [3, 4] to find out how many missing number in between
				missed += arr[i] - arr[i - 1] - 1;
				if(missed >= k ){
					// return back the missing number back to the previous state
					missed -= arr[i] - arr[i - 1] - 1;
					int result = arr[i - 1];
					// loop to find out the kth missing number
					while(missed++ < k){
						result++;
					}
					return result;
				}
			}
		}
		// case 1 where there is no missing 
		int result = arr[arr.length - 1];
		while(missed++ < k){
			result++;
		}
		return result;
    }
}

/*
Input: arr = [2,3,4,7,11], k = 5
Output: 9
Input: arr = [1,2,3,4], k = 2
Output: 6
*/



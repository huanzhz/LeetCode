
//https://www.youtube.com/watch?v=vyrEra_OfDo
//LeetCode 1619. Mean of Array After Removing Some Elements - Interview Prep Ep 99
//https://leetcode.com/problems/mean-of-array-after-removing-some-elements/

class Solution{
	public double trimMean(int[] arr){
		Arrays.sort(arr);
		int n = arr.length;
		long sum= 0;
		// first get to the 5 percent
		// remove the last 5 percent 
		for(int i = (int)Math.round(n * 0.05); i < n - 0.05*n; i++){
			sum += arr[i];
		}
		return sum / (n - n * 0.1);
	}
}

/*
Input: arr = [1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,3]
Output: 2.00000
Input: arr = [6,2,7,5,1,2,0,3,10,2,5,0,5,5,0,8,7,6,8,0]
Output: 4.00000
Input: arr = [6,0,7,0,7,5,7,8,3,4,0,7,8,1,6,8,1,1,2,4,8,1,9,5,4,3,8,5,10,8,6,6,1,0,6,10,8,2,3,4]
Output: 4.77778
Input: arr = [9,7,8,7,7,8,4,4,6,8,8,7,6,8,8,9,2,6,0,0,1,10,8,6,3,3,5,1,10,9,0,7,10,0,10,4,1,10,6,9,3,6,0,0,2,7,0,6,7,2,9,7,7,3,0,1,6,1,10,3]
Output: 5.27778
*/



//https://www.youtube.com/watch?v=v6On1TQfMTU
//LeetCode 1535. Find the Winner of an Array Game - Interview Prep Ep 86
//https://leetcode.com/problems/find-the-winner-of-an-array-game/

class Solution {
    public int getWinner(int[] arr, int k) {
        int winner = arr[0];
		int winTimes = 0;
		// loop through the array to find the biggest number
		for(int i = 1; i < arr.length; i++){
			// set the winner if which is larger
			if(arr[i] > winner){
				winner = arr[i];
				winTimes = 1;
			} else {
				winTimes++;
			}
			
			// if more than k time 
			if(winTimes >= k){
				return winner;
			}
		}
		return winner;
    }
}

/*
Input: arr = [3,2,1], k = 10
Output: 3
Input: arr = [1,9,8,2,3,7,6,4,5], k = 7
Output: 9
Input: arr = [1,11,22,33,44,55,66,77,88,99], k = 1000000000
Output: 99
*/

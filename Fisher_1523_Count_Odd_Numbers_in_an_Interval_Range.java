
//https://www.youtube.com/watch?v=TkT-6WsmqY0
//LeetCode 1523. Count Odd Numbers in an Interval Range - Interview Prep Ep 85
//https://leetcode.com/problems/count-odd-numbers-in-an-interval-range/

/*
1. if both low and high boundaries are even numbers: 
	divide the difference between these two boundaries by two and return;
2. if either of the two boundaries is an odd number: 
	divide the difference between these two boundaries by two then plus one and return.
*/
class Solution {
    public int countOdds(int low, int high) {
		// even number
        if(low % 2 == 0 && high % 2 == 0){
			return (high - low) / 2;
		}
		return (high - low) / 2 + 1;
    }
}

/*
Input: low = 3, high = 7
Output: 3
Input: low = 8, high = 10
Output: 1
Input: low = 7, high = 9
Output: 2
*/


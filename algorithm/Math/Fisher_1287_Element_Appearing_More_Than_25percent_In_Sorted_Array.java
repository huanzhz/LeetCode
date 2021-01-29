
//https://www.youtube.com/watch?v=G74W8v2yVjY
//LeetCode 1287: Element Appearing More Than 25% In Sorted Array - Interview Prep Ep 42
//https://leetcode.com/problems/element-appearing-more-than-25-in-sorted-array/

class Solution {
    public int findSpecialInteger(int[] arr) {
		// divide by 4 because 25% 
        int quarter = arr.length / 4;
		for(int i = 0; i < arr.length - quarter; i++){
			if(arr[i] == arr[i + quarter]){
				return arr[i];
			}
		}
		return -1;
    }
}

/*
Input: arr = [1,2,2,6,6,6,6,7,10]
Output: 6
*/
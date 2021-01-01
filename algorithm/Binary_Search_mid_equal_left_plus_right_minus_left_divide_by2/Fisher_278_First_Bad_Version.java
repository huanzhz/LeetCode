
//https://www.youtube.com/watch?v=E15djRphPj0
//LeetCode 278. First Bad Version - Interview Prep Ep 74
//https://leetcode.com/problems/first-bad-version/

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

// Binary search -> check middle point
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1;
		int right = n;
		while(left < right){
			//find the middle point
			int mid = left + (right - left) / 2;
			if(isBadVersion(mid)){
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		return left;
    }
}

/*
Input: n = 5, bad = 4
Output: 4
Input: n = 1, bad = 1
Output: 1
*/

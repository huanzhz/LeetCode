
//https://www.youtube.com/watch?v=tm1Yrb_SfBM
//LeetCode 7: Reverse Integer - Interview Prep Ep 55
//https://leetcode.com/problems/reverse-integer/

class Solution {
    public int reverse(int x) {
        int result = 0;
		while(x != 0){
			int lastDight = x % 10;
			int newResult = result * 10 + lastDight;
			if((newResult - lastDight) / 10 != result){
				// overflow
				return 0;
			}
			
			// remove the last value
			x /= 10;
			result = newResult;
		}
		return result;
    }
}




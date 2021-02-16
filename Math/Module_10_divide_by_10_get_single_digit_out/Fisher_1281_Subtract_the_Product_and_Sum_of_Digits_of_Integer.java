
//https://www.youtube.com/watch?v=kUFaMqz5ArI
//LeetCode 1281: Subtract the Product and Sum of Digits of Integer - Interview Prep Ep 25
//https://leetcode.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/

class Solution {
    public int subtractProductAndSum(int n) {
        // n = 234
		// n % 10 -> 234 % 10 = 4
		// n /= 10 -> 234 /= 10 = 23 -> 2 -> 0
		
		int sum = 0;
		int product = 1;
		while(n > 0){
			int digit = n % 10;
			sum += digit;
			product *= digit;
			n /= 10;
		}
		return product - sum;
    }
}


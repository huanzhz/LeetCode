
//https://www.youtube.com/watch?v=HKjt0f1N0GA
//LeetCode 66: Plus One - Interview Prep Ep 51
//https://leetcode.com/problems/plus-one/

// case Input digit is limited to overflow
class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
		// start from the end
		for(int i = len - 1; i >= 0; i--){
			// if last digits is less than 9
			if(digits[i] < 9){
				digits[i]++;
				return digits;
			}
			// if last digit is 9 then set it to 0
			digits[i] = 0;
		}
		// if all digits is 9
		int[] newNumber = new int[len + 1];
		// set the first number to 1
		newNumber[0] = 1;
		return newNumber;
    }
}

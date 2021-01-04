
//https://leetcode.com/problems/count-good-meals/discuss/999119/Java-HashMap-Two-Sum-O(N)
//https://leetcode.com/contest/weekly-contest-222/problems/count-good-meals/

class Solution {
    int mod = 1000000007;
    public int countPairs(int[] deliciousness) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = deliciousness.length;
		// res -> result
        long res = 0;
        for (int num : deliciousness) {
            int power = 1;
            for (int i = 0; i < 22; i++) {
				// power of 2 - num 
				// 2,4,8,16
                if (map.containsKey(power - num)) {
                    res += map.get(power - num);
                    res %= mod;
                }
                power *= 2;
            }
			// put the number into the hashmap and increase by 1, default is 0
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return (int) res;
    }
}

/*
Input: deliciousness = [1,3,5,7,9]
Output: 4
Explanation: The good meals are (1,3), (1,7), (3,5) and, (7,9).
Their respective sums are 4, 8, 8, and 16, all of which are powers of 2.

Input: deliciousness = [1,1,1,3,3,3,7]
Output: 15
Explanation: The good meals are (1,1) with 3 ways, (1,3) with 9 ways, and (1,7) with 3 ways.
*/


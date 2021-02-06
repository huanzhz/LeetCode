
//https://www.youtube.com/watch?v=gJ8VcJ8f_Vk
//LeetCode 136: Single Number - Interview Prep Ep 35
//https://leetcode.com/problems/single-number/

class Solution {
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet();
		for(int num : nums){
			if(!set.add(num)){
				set.remove(num);
			}
		}
		return set.iterator().next();
    }
}


// xor
// 0 0 = 0
// 1 1 = 0
// 0 1 = 1
// 1 0 = 1


// 2 | 2 = 0
// 1 0
// 1 0
// 0 0

class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
		for(int num : nums){
			result ^= num;
		}
		return result;
    }
}

/*

Input: nums = [2,2,1]
Output: 1

Input: nums = [4,1,2,1,2]
Output: 4
*/
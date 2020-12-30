
//https://www.youtube.com/watch?v=GVecnelW8mA
//LeetCode 904. Fruit Into Baskets - Interview Prep Ep 102
//https://leetcode.com/problems/fruit-into-baskets/

//slide window
class Solution {
    public int totalFruit(int[] tree) {
        int maxFruits = 0;
		Set<Integer> set = new HashSet();
		int startIndex = 0;
		for(int i = 0; i < tree.length; i++){
			// the set only contain 2 number
			if(set.size() < 2 || set.contains(tree[i])){
				set.add(tree[i]);
				maxFruits = Math.max(maxFruits, i - startIndex + 1);
			} else {
				// when there is 3 different number
				// 0 1 2 -> current position 2 which will give 1 as 2nd number
				// lastone -> is the 2nd number insert into the set
				int lastOne = tree[i - 1];
				// i - 2 give the current position last 3rd number, going from the back of the array
				// 0 1 2 -> current position 2 which will give 0 as 3rd number
				for(int j = i - 2; j >= 0; j--){
					if(tree[j] != lastOne){
						startIndex = j + 1;
						// remove the odd one out in the set
						// 0 1 2 -> number 0 is removed
						set.remove(tree[j]);
						break;
					}
				}
				// add the new number to the set
				// 0 1 2 -> number 2 into the set
				set.add(tree[i]);
				maxFruits = Math.max(maxFruits, i - startIndex + 1);
			}
		}
		return maxFruits;
    }
}

/*
Input: [1,2,1]
Output: 3
Input: [0,1,2,2]
Output: 3
Input: [1,2,3,2,2]
Output: 4
Input: [3,3,3,1,2,1,1,2,3,3,4]
Output: 5
*/

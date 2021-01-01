
//https://www.youtube.com/watch?v=E0OkE3G95vU
//LeetCode 1090. Largest Values From Labels - Interview Prep Ep 104
//https://leetcode.com/problems/largest-values-from-labels/

class Solution {
    public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
        int n = values.length;
		int[][] tuple = new int[n][2];
		// store the value and labes array
		for(int i = 0; i < n; i++){
			tuple[i][0] = values[i];
			tuple[i][1] = labels[i];
		}
		// Sort them descending order
		Arrays.sort(tuple, (a, b) -> b[0] - a[0]);
		// Keep track of the limit 
		Map<Integer, Integer> map = new HashMap();
		int numbers = 0;
		int sum = 0;
		for(int i = 0; i < n; i++){
			int val = tuple[i][0];
			// get the key of the map 
			// https://www.geeksforgeeks.org/hashmap-getordefaultkey-defaultvalue-method-in-java-with-examples/
			// getOrDefault(Object key, V defaultValue)
			// if key found and has no value return 0 || key cannot be found return 0
			int usedTimes = map.getOrDefault(tuple[i][1], 0);
			if(usedTimes >= use_limit){
				continue;
			} else {
				sum += val;
				// add the value to the map
				map.put(tuple[i][1], usedTimes + 1);
				numbers++;
			}
			// number selected must be below given variable
			if(numbers >= num_wanted){
				break;
			}
		}
		return sum;
    }
}

/*
Input: values = [5,4,3,2,1], labels = [1,1,2,2,3], num_wanted = 3, use_limit = 1
Output: 9
Input: values = [5,4,3,2,1], labels = [1,3,3,3,2], num_wanted = 3, use_limit = 2
Output: 12
Input: values = [9,8,8,7,6], labels = [0,0,0,1,1], num_wanted = 3, use_limit = 1
Output: 16
Input: values = [9,8,8,7,6], labels = [0,0,0,1,1], num_wanted = 3, use_limit = 2
Output: 24
*/




//https://www.youtube.com/watch?v=mH1aEjOEjcQ
//LeetCode 1200: Minimum Absolute Difference - Interview Prep Ep 2
//https://leetcode.com/problems/minimum-absolute-difference/

class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        //Time: O(nlogn)
        //Space: O(1)

        // Sort the array
        Arrays.sort(arr);
        // First 2 number difference
        int currentMinDiff = arr[1] - arr[0];
        // A List contain a List of integer array
        List<List<Integer>> result = new ArrayList();
        // Add the first 2 
        result.add(Arrays.asList(arr[0], arr[1]));
        for(int i = 2; i < arr.length; i++){
            // get the difference from the current and the previous number
            int diff = arr[i] - arr[i-1];
            if(currentMinDiff == diff){
                result.add(Arrays.asList(arr[i-1], arr[i]));
            } else if (currentMinDiff > diff){
                // found a new min different
                currentMinDiff = diff;
                result = new ArrayList();
                result.add(Arrays.asList(arr[i - 1], arr[i]));
            }
        }
        return result;
    }
}

/*
Input: arr = [4,2,1,3]
Output: [[1,2],[2,3],[3,4]]
Explanation: The minimum absolute difference is 1. List all pairs with difference equal to 1 in ascending order.
Input: arr = [1,3,6,10,15]
Output: [[1,3]]
Input: arr = [3,8,-10,23,19,-4,-14,27]
Output: [[-14,-10],[19,23],[23,27]]
*/


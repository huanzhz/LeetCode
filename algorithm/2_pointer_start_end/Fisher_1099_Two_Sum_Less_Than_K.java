
//https://www.youtube.com/watch?v=2Uq7p7HE0TI
//LeetCode 1099: Two Sum Less Than K - Interview Prep Ep 6
//https://leetcode.com/problems/two-sum-less-than-k/
//https://github.com/fishercoder1534/Leetcode/blob/master/src/main/java/com/fishercoder/solutions/_1099.java

public static class Solution1 {
    /**
     * Time: O(n^2)
     * Space: O(1)
     */
    public int twoSumLessThanK(int[] A, int K) {
        // init the maxSum variable 
        int maxSum = Integer.MIN_VALUE;
        // loop through all the combination of 2 numbers to find the max sum which less than K
        for (int i = 0; i < A.length - 1; i++) {
            for (int j = i + 1; j < A.length; j++) {
                if (A[i] + A[j] < K) {
                    maxSum = Math.max(maxSum, A[i] + A[j]);
                }
            }
        }
        // if there is no value return -1 
        return maxSum == Integer.MIN_VALUE ? -1 : maxSum;
    }
}

public static class Solution2 {
    /**
     * Time: O(nlogn)
     * Space: O(1)
     */
    public int twoSumLessThanK(int[] A, int K) {
        // sort asc order
        Arrays.sort(A);
        // 2pointers method
        int left = 0;
        int right = A.length - 1;
        int sum = Integer.MIN_VALUE;
        while (left < right) {
            int newSum = A[left] + A[right];
            if (newSum < K && newSum > sum) {
                sum = newSum;
            } else if (newSum >= K) {
                right--;
            } else {
                left++;
            }
        }
        // if there is no value return -1 
        return sum == Integer.MIN_VALUE ? -1 : sum;
    }
}



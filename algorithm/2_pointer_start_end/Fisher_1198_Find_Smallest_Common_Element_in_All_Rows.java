
//https://www.youtube.com/watch?v=RMiofZrTmWo
//LeetCode 1198: Find Smallest Common Element in All Rows - Interview Prep Ep 9
//https://leetcode.com/problems/find-smallest-common-element-in-all-rows/
//https://github.com/fishercoder1534/Leetcode/blob/master/src/main/java/com/fishercoder/solutions/_1198.java

/*
mat = [[1,2,3,4,5],[2,4,5,8,10],[3,5,7,9,11],[1,3,5,7,9]]
5
*/
public int smallestCommonElement(int[][] mat) {
    int m = mat.length;
    int n = mat[0].length;
    for (int j = 0; j < n; j++) {
        int minCommon = mat[0][j];
        //we'll start from the second row
        int i = 1;
        for (; i < m; i++) {
            if (thisRowHasThisNumber(mat[i], minCommon)) {
                continue;
            } else {
                break;
            }
        }
        // finish all the row
        if (i == m) {
            return minCommon;
        }
    }
    // dont find an answer
    return -1;
}

private boolean thisRowHasThisNumber(int[] nums, int target) {
    // 2 ptr, because the array is sort in asc order
    int left = 0;
    int right = nums.length - 1;
    while (left <= right) {
        int mid = left + (right - left) / 2;
        // if we found the number
        if (target == nums[mid]) {
            return true;
        } else if (target > nums[mid]) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    return false;
}



//https://www.youtube.com/watch?v=zceoOrHSHNQ
//LeetCode 1213: Intersection of Three Sorted Arrays - Interview Prep Ep 5
//https://leetcode.com/problems/intersection-of-three-sorted-arrays/
//https://github.com/fishercoder1534/Leetcode/blob/master/src/main/java/com/fishercoder/solutions/_1213.java

public static class Solution1 {
    /**
     * credit: https://leetcode.com/problems/intersection-of-three-sorted-arrays/discuss/397603/Simple-Java-solution-beats-100
     */
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> result = new ArrayList();
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < arr1.length && j < arr2.length && k < arr3.length) {
            // if it is match then increase all pointers|interger
            if (arr1[i] == arr2[j] && arr1[i] == arr3[k]) {
                result.add(arr1[i]);
                i++;
                j++;
                k++;
            } else if (arr1[i] < arr2[j]) {
                i++;
            } else if (arr2[j] < arr3[k]) {
                j++;
            } else {
                k++;
            }
        }
        return result;
    }
}

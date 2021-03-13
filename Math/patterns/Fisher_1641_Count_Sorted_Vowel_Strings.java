
//https://www.youtube.com/watch?v=gdH4yfgfwiU
//LeetCode 1641. Count Sorted Vowel Strings - Interview Prep Ep 114
//https://leetcode.com/problems/count-sorted-vowel-strings/

class Solution {
    public int countVowelStrings(int n) {
        if(n == 1){
            return 5;
        }
        int[] arr = new int[]{1, 1, 1, 1, 1};
        int sum = 5;
        for(int i = 2; i <= n; i++){
            int[] copy = new int[5];
            for(int j = 0; j < 5; j++){
                if(j == 0){
                    copy[j] = sum;
                } else {
                    // math pattern 5 - 1 = 4, 15 - 5 = 10, ...
                    copy[j] = copy[j - 1] - arr[j - 1];
                }
            }
            arr = Arrays.copyOf(copy, 5);
            sum = 0;
            for(int j = 0; j < 5; j++){
                // new sum equal the old sum of whole array
                sum += arr[j];
            }
        }
        return sum;
    }
}



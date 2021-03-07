
//https://www.youtube.com/watch?v=GKYmPuHZpQg
//LeetCode 1085: Sum of Digits in the Minimum Number - Interview Prep Ep 8
//https://leetcode.com/problems/sum-of-digits-in-the-minimum-number/
//https://github.com/fishercoder1534/Leetcode/blob/master/src/main/java/com/fishercoder/solutions/_1085.java

//[34,23,1,24,75,33,54,8]
// output -> 0 because 1 is minimum and sum or 1 is 1

//[99,77,33,66,55]
// output -> 1 because sum of 33 is 6 and is even number

public int sumOfDigits(int[] A) {
    int smallestNumber = A[0];
    // find the smallest number in the array
    for (int i = 1; i < A.length; i++) {
        smallestNumber = Math.min(smallestNumber, A[i]);
    }
    int sum = 0;
    // find the sum of the digit
    while (smallestNumber > 0) {
        sum += smallestNumber % 10;
        smallestNumber /= 10;
    }
    // if mod by 2 and get 0 then it true and return 1 else return 0 false
    return sum % 2 == 0 ? 1 : 0;
}



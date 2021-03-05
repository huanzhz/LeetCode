
//https://www.youtube.com/watch?v=HTL7fd4HPf4
//LeetCode 1134: Armstrong Number - Interview Prep Ep 10
//https://leetcode.com/problems/armstrong-number/
//https://github.com/fishercoder1534/Leetcode/blob/master/src/main/java/com/fishercoder/solutions/_1134.java

public boolean isArmstrong(int N) {
    int numOfDigits = 0;
    int copyN = N;
    // count the number of digits
    while (copyN > 0) {
        copyN /= 10;
        numOfDigits++;
    }
    int sum = 0;
    copyN = N;
    // get the power of each digit
    while (N > 0) {
        int digit = N % 10;
        sum += Math.pow(digit, numOfDigits);
        N /= 10;
    }
    // check if power sum eqaul to the original
    return sum == copyN;
}


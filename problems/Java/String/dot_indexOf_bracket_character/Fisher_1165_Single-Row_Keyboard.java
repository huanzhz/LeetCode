
//https://www.youtube.com/watch?v=nxn8sPTGDwA
//LeetCode 1165: Single-Row Keyboard - Interview Prep Ep 4
//https://leetcode.com/problems/single-row-keyboard/
//https://github.com/fishercoder1534/Leetcode/blob/master/src/main/java/com/fishercoder/solutions/_1165.java


// given key board "asdfghjklqwertyuiopzxcvbnm"
// given word "ama"
// from a to m then back to a , what the number of steps moved.
public static class Solution1 {
    public int calculateTime(String keyboard, String word) {
        int time = 0;
        int fromIndex = 0;
        for (char c : word.toCharArray()) {
            int fingerMoves = Math.abs(fromIndex - keyboard.indexOf(c));
            fromIndex = keyboard.indexOf(c);
            time += fingerMoves;
        }
        return time;
    }
}

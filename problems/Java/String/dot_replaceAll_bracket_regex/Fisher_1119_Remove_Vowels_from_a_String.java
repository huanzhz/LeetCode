
//https://www.youtube.com/watch?v=6KCBrIWEauw
//LeetCode 1119: Remove Vowels from a String - Interview Prep Ep 3
//https://leetcode.com/problems/remove-vowels-from-a-string/
//https://github.com/fishercoder1534/Leetcode/blob/master/src/main/java/com/fishercoder/solutions/_1119.java

public static class Solution1 {
    public String removeVowels(String S) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : S.toCharArray()) {
            if (!vowels.contains(c)) {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }
}

public static class Solution2 {
    public String removeVowels(String S) {
        return S.replaceAll("[aeiou]", "");
    }
}


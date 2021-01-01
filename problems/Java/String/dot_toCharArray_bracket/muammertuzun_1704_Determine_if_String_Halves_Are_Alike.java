
//https://leetcode.com/contest/weekly-contest-221/problems/determine-if-string-halves-are-alike/
//https://leetcode.com/problems/determine-if-string-halves-are-alike/discuss/994190/Simple-Java-Solution

class Solution {
    public boolean halvesAreAlike(String s) {
		// change the String to lower case
        s = s.toLowerCase();

		// String to char array to can access each character
        char[] chars = s.toCharArray();
		// counters for a and b string to match they are equal
        int a = 0, b = 0;

		// set i at the start and j at the end of the string
        for (int i = 0, j = s.length() - 1; i < s.length() / 2; i++, j--) {
            if(isVowel(chars[i])){
                a++;
            }
            if (isVowel(chars[j])){
                b++;
            }
        }

        return a == b;
    }

	// function to check for vowel
    private boolean isVowel(char c) {
        if(c == 'a' || c == 'e' || c == 'i' ||c == 'u' ||c == 'o'){
            return true;
        }
        return false;
    }
}

/*
Input: s = "book"
Output: true
Input: s = "textbook"
Output: false
Input: s = "MerryChristmas"
Output: false
Input: s = "AbCdEfGh"
Output: true
*/

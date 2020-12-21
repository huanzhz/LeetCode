
//https://www.youtube.com/watch?v=-jXQK-UeChU
//LeetCode 1657. Determine if Two Strings Are Close - Interview Prep Ep 100
//https://leetcode.com/problems/determine-if-two-strings-are-close/

class Solution {
	public boolean closeStrings(String word1, String word2){
		int[] counts1 = new int[26];
		int[] counts2 = new int[26];
		// What is HashSet?
		//https://www.youtube.com/watch?v=WPcKwA5WF7s
		//Java HashSet Tutorial	
		// no duplicates
		Set<Character> set1 = new HashSet<Character>();
		Set<Character> set2 = new HashSet<Character>();
		for(char c : word1.toCharArray()){
			counts1[c - 'a']++;
			// .add() return a boolean true or false
			set1.add(c);
		}
		for(char c : word2.toCharArray()){
			counts2[c - 'a']++;
			set2.add(c);
		}
		// Sort them so we can know they are swapable.
		// counts1 contain array of integer, for example abbc -> [1 2 1] after sort -> [1 1 2]
		Arrays.sort(counts1);
		Arrays.sort(counts2);
		// first condition to check 
		// second condition is to check the size/length of both words are the same.
		return set1.equals(set2) && Arrays.equals(counts1, counts2);
	}
}

//ArrayList
// 	index
//	inorder
// 1,2,3,4 bob.add()
// [0][1][2][3]

//HashSet
// no order
// 1,2,3,4 mySet.add()
// 3,1,4,2
// use for each loop to loop through

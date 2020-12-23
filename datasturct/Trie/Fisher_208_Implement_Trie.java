
//https://www.youtube.com/watch?v=Br7Wt4V5o1c
//Trie Data Structure | LeetCode 208. Implement Trie (Prefix Tree) - Interview Prep Ep 83
//https://leetcode.com/problems/implement-trie-prefix-tree/

// time O(w)
// look up once


class TrieNode {
	boolean isWord;
	TrieNode[] children = new TrieNode[26];
}

class Trie {
	
	TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
		TrieNode node = root;
        for(int i = 0; i < word.length(); i++){
			//if the character no exist in the tree, add a new node
			if(node.children[word.charAt(i) - 'a'] == null){
				node.children[word.charAt(i) - 'a'] = new TrieNode();
			}
			// move to the new node, and loop again
			node = node.children[word.charAt(i) - 'a'];
		}
		// last word set true
		node.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = root;
		for(int i = 0; i < word.length(); i ++){
			// if there is no such word, return cannot be found
			if(node.children[word.charAt(i) - 'a'] == null){
				return false;
			}
			node = node.children[word.charAt(i) - 'a'];
		}
		// the node can be found
		return node.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
		for(int i = 0; i < prefix.length(); i++){
			if(node.children[prefix.charAt(i) - 'a'] == null){
				return false;
			}
			node = node.children[prefix.charAt(i) - 'a'];
		}
		return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */





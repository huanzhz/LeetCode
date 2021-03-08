
//https://www.youtube.com/watch?v=PLNDfB0Vg9Y
//LeetCode 1268. Search Suggestions System - Interview Prep Ep 103
//https://leetcode.com/problems/search-suggestions-system/

class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        // create the Trie Tree 
        TrieNode root = buildTrie(products);
        List<List<String>> result = new ArrayList<>();
        // loop through the word
        for (int i = 1; i <= searchWord.length(); i++) {
            // find top three matches
            result.add(findTopThreeMatches(root, searchWord.substring(0, i)));
        }
        return result;
    }

    private List<String> findTopThreeMatches(TrieNode root, String searchTerm) {
        List<String> result = new ArrayList<>();
        TrieNode node = root;
        for (char c : searchTerm.toCharArray()) {
            // check if the alphabet exist 
            if (node.children[c - 'a'] == null) {
                return result;
            } else {
                node = node.children[c - 'a'];
            }
        }
        if (node.isWord) {
            // if current word exist "mob" then add it into the result
            result.add(searchTerm);
        }
        // return the frist 3 result of mob* -> where * is a to z, moba,mobb,mobc...
        for (TrieNode child : node.children) {
            if (child != null) {
                List<String> thisResult = dfs(child, searchTerm, new ArrayList<>());
                result.addAll(thisResult);
                if (result.size() >= 3) {
                    return result.subList(0, 3);
                }
            }
        }
        return result;
    }

    private List<String> dfs(TrieNode node, String substring, List<String> result) {
        if (node.isWord) {
            result.add(substring + node.c);
            if (result.size() >= 3) {
                return result;
            }
        }
        for (TrieNode child : node.children) {
            if (child != null) {
                dfs(child, substring + node.c, result);
            }
        }
        return result;
    }

    private TrieNode buildTrie(String[] products) {
        TrieNode root = new TrieNode(' ');
        for (String pro : products) {
            insert(pro, root);
        }
        return root;
    }

    private void insert(String word, TrieNode root) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode(c);
            }
            node = node.children[c - 'a'];
        }
        node.isWord = true;
    }

    class TrieNode {
        TrieNode[] children;        // the next alphabet
        boolean isWord;             // ending letter 
        char c;                     // the letter in this node 

        public TrieNode(char c) {
            this.c = c;
            this.children = new TrieNode[26];
        }
    }
}

/*
Input: products = ["mobile","mouse","moneypot","monitor","mousepad"], searchWord = "mouse"
Output: [
["mobile","moneypot","monitor"],
["mobile","moneypot","monitor"],
["mouse","mousepad"],
["mouse","mousepad"],
["mouse","mousepad"]
]
Explanation: products sorted lexicographically = ["mobile","moneypot","monitor","mouse","mousepad"]
After typing m and mo all products match and we show user ["mobile","moneypot","monitor"]
After typing mou, mous and mouse the system suggests ["mouse","mousepad"]
*/
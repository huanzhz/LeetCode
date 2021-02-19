
//https://www.youtube.com/watch?v=2Pe6e0KbgFI
//LeetCode 100: The Same Tree - Interview Prep Ep 21
//https://leetcode.com/problems/same-tree/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null || q == null){
			return p == q;
		}
		return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}



//https://www.youtube.com/watch?v=F85boSPtfKg
//LeetCode 101: Symmetric Tree - Interview Prep Ep 22
//https://leetcode.com/problems/symmetric-tree/

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
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
			return true;
		}
		return isSymmetric(root.left, root.right);
    }
	
	// https://beginnersbook.com/2014/01/difference-between-method-overloading-and-overriding-in-java/
	// overloading method
	private boolean isSymmetric(TreeNode left, TreeNode right){
		// ending condition
		if(left == null || right == null){
			return left == right;
		}
		// not symmetric
		if(left.val != right.val){
			return false;
		}
		// return the depth
		return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
	}
}


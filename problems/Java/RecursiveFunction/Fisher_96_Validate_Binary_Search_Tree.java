
//https://www.youtube.com/watch?v=kR5AxWHa9nc
//LeetCode 98. Validate Binary Search Tree - Interview Prep Ep 69
//https://leetcode.com/problems/validate-binary-search-tree/

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
    public boolean isValidBST(TreeNode root) {
        if (root == null){
			return true;
		}
		return dfs(root, null, null);
    }
	
	private boolean dfs(TreeNode root, Integer min, Integer max){
		if(root == null){
			return true;
		}
		if((min != null && root.val <= min) || (max != null && root.val >= max)){
			return false;
		}
		// recursive the left and right node, set the min for right tree, max for left tree 
		return dfs(root.left, min, root.val) && dfs(root.right, root.val, max);
	}
}


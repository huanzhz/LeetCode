
//https://www.youtube.com/watch?v=367McfIeBDM
//LeetCode 144. Binary Tree Preorder Traversal RECURSIVELY - Interview Prep Ep 67
//https://leetcode.com/problems/binary-tree-preorder-traversal/

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
 // Node->Left->Right
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        return dfs(root, new ArrayList());
    }
	
	private List<Integer> dfs(TreeNode root, List<Integer> list){
		if(root == null){
			return list;
		}
		list.add(root.val);
		list = dfs(root.left, list);
		return dfs(root.right, list);
	}
}


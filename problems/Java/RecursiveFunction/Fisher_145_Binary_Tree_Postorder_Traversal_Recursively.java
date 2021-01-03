
//https://www.youtube.com/watch?v=B6XTLPpsW7k
//LeetCode 145. Binary Tree Postorder Traversal RECURSIVELY - Interview Prep Ep 68
//https://leetcode.com/problems/binary-tree-postorder-traversal/

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
 // Left->Right->Node
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        return dfs(root, new ArrayList());
    }
	
	private List<Integer> dfs(TreeNode root, List<Integer> list){
		if(root == null){
			return list;
		}
		list = dfs(root.left, list);
		list = dfs(root.right, list);
		list.add(root.val);
		return list;
	}
}

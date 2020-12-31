
//https://www.youtube.com/watch?v=QxFOR8sQuB4
//LeetCode 94. Binary Tree Inorder Traversal ITERATIVELY - Interview Prep Ep 75
//https://leetcode.com/problems/binary-tree-inorder-traversal/

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
 // Left->Root->Right Inorder
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
		List<Integer> list = new ArrayList();
		while(!stack.isEmpty() || root != null){
			// find the most left node 
			while(root != null){
				// push the root onto the stack
				stack.push(root);
				// move to the left node as root
				root = root.left;
			}
			// left node is null hence pop the root node on stack
			root = stack.pop();
			// add the root to the list as it is the left most node
			list.add(root.val);
			// set the root to the right node
			root = root.right;
		}
		return list;
    }
}



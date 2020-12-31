
//https://www.youtube.com/watch?v=vMHaqhiTn7Y
//LeetCode 144. Binary Tree Preorder Traversal ITERATIVELY - Interview Prep Ep 76
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
 // Root Left Right	-> Preorder
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList();
		Stack<TreeNode> stack = new Stack();
		while(!stack.isEmpty() || root != null){
			while(root != null){
				// add the root node
				list.add(root.val);
				// push the root to the stack
				stack.push(root);
				// move to the left node
				root = root.left;
			}
			// if left node is null, go back to the root node
			root = stack.pop();
			// move to the right node 
			root = root.right;
		}
		return list;
    }
}

// stack solution
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList();
		Stack<TreeNode> stack = new Stack();
		stack.push(root);
		while(!stack.isEmpty()){
			TreeNode curr = stack.pop();
			if(curr != null){
				list.add(curr.val);
				stack.push(curr.right);
				stack.push(curr.left);
			}
		}
		return list;
    }
}

/*
Input: root = [1,null,2,3]
Output: [1,2,3]
*/


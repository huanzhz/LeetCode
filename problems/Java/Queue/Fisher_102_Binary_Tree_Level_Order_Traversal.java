
//https://www.youtube.com/watch?v=sFDNL6r5aDM
//LeetCode 102. Binary Tree Level Order Traversal - Interview Prep Ep 70
//https://leetcode.com/problems/binary-tree-level-order-traversal/

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
    public List<List<Integer>> levelOrder(TreeNode root) {
		// List contain a list -> double array
        List<List<Integer>> result = new ArrayList();
		if(root == null){
			return result;
		}
		// create a queue that is class of TreeNode(above) as a linked list
		Queue<TreeNode> q = new LinkedList();
		// offer is same as add
		q.offer(root);
		while(!q.isEmpty()){
			int size = q.size();
			// keep track of same level
			List<Integer> level = new ArrayList();
			for(int i = 0; i < size; i++){
				// take the first one out of the queue
				TreeNode curr = q.poll();
				// add to the current level 
				level.add(curr.val);
				if(curr.left != null){
					q.add(curr.left);
				}
				if(curr.right != null){
					q.add(curr.right);
				}
			}
			result.add(level);
		}
		return result;
    }
}





//https://www.youtube.com/watch?v=VVSnM5DGvjg
//LeetCode 108. Convert Sorted Array to Binary Search Tree - Interview Prep Ep 71
//https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/

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
    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }
	
	private TreeNode dfs(int [] nums, int start, int end){
		if(end < start){
			return null;
		}
		// find the middle point
		int mid = (start + end) / 2;
		// set the root node
		TreeNode root = new TreeNode(nums[mid]);
		// recursive the function for left node 
		root.left = dfs(nums, start, mid - 1);
		// recursive the function for right node 
		root.right = dfs(nums, mid + 1, end);
		return root;
	}
}

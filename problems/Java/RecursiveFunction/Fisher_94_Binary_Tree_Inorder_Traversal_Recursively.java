
//https://www.youtube.com/watch?v=o_T8MswDI_Y
//LeetCode 94. Binary Tree Inorder Traversal RECURSIVELY - Interview Prep Ep 66
//https://leetcode.com/problems/binary-tree-inorder-traversal/

// Left->Node->Right
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        return dfs(root, new ArrayList());
    }
	
	private List<Integer> dfs(TreeNode root, List<Integer> list){
		if(root == null){
			return list;
		}
		
		list = dfs(root.left, list);
		list.add(root.val);
		return dfs(root.right, list);
	}
}

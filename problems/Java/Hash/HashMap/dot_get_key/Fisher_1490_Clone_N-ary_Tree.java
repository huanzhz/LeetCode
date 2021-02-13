
//https://www.youtube.com/watch?v=3Wnja3Bxeos
//LeetCode 1490. Clone N-ary Tree - Interview Prep Ep 110
//https://leetcode.com/problems/clone-n-ary-tree/
//https://github.com/fishercoder1534/Leetcode/blob/master/src/main/java/com/fishercoder/solutions/_1490.java

/*
// Definition for a Node.
class Node {
	public int val;
	public List<Node> children;
	
	public Node(){
		children = new ArrayList<Node>();
	}
	
	public Node(int _val){
		val = _val;
		children = new ArrayList<Node>();
	}
	
	public Node(int _val, ArrayList<Node> _children){
		val = _val;
		childred = _children;
	}
};
*/


// root = [1,null,3,2,4,null,5,6]
public Node cloneTree(Node root) {
	if (root == null) {
		return root;
	}
	// key, value
	Map<Node, Node> map = new HashMap<>();
	// [1,null,3,2,4,null,5,6], [1]
	map.put(root, new Node(root.val));
	
	Queue<Node> queue = new LinkedList<>();
	// [1,null,3,2,4,null,5,6]
	queue.offer(root);
	
	while (!queue.isEmpty()) {
		// curr = [1,null,3,2,4,null,5,6] 
		Node curr = queue.poll();
		for (Node child : curr.children) {
			// BFS, breath first search, level by level
			Node childCopy = new Node(child.val);
			if (!map.containsKey(child)) {
				// if not inside the HashMap then add 
				map.put(child, childCopy);
				queue.offer(child);
			}
			// get [1] add [null,3,2,4,null,5,6] 
			map.get(curr).children.add(childCopy);
		}
	}
	return map.get(root);
}

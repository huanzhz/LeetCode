
//https://www.youtube.com/watch?v=IfsiNU7J-6c
//LeetCode 1557. Minimum Number of Vertices to Reach All Nodes - Interview Prep Ep 94
//https://leetcode.com/problems/minimum-number-of-vertices-to-reach-all-nodes/

//topological sorting solution

class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        Map<Integer, Integer> indegree = new HashMap();
		for(List<Integer> edge : edges){
			// get the node being pointed at
			int end = edge.get(1);
			// incoming pointers to the node
			indegree.put(end, indegree.getOrDefault(end, 0) + 1 );
		}
		List<Integer> result = new ArrayList();
		for(int i = 0; i < n; i++){
			// if the node has no incoming pointers, it will be start pointer
			if(!indegree.containsKey(i)){
				result.add(i);
			}
		}
		return result;
    }
}

/*
Input: n = 6, edges = [[0,1],[0,2],[2,5],[3,4],[4,2]]
Output: [0,3]
Input: n = 5, edges = [[0,1],[2,1],[3,1],[1,4],[2,4]]
Output: [0,2,3]
*/

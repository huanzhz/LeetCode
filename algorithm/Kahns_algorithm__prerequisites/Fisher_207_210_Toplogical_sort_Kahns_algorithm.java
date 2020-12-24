
//https://www.youtube.com/watch?v=2l22FRtU45M
//LeetCode 207 & 210: Course Schedule I & II | Topological Sort | Kahn's algorithm - Interview Ep 78
//https://leetcode.com/problems/course-schedule/

//Time complexity: O(V+E) (V is the number of vertices and E is the number of edges in the given graph)

//207
// no directed cycles -> a loop between 3 node that requires each other
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
		// check how many node it can point to
		for(int[] pre : prerequisites){
			indegree[pre[0]]++;
		}
		// starting set where no other pointing at them
		Set<Integer> zeroDegree = new HashSet();
		for(int i = 0; i < numCourses; i++){
			if(indegree[i] == 0){
				zeroDegree.add(i);
			}
		}
		// check if valid deck
		if(zeroDegree.isEmpty()){
			return false;
		}
		// while startSet is not empty
		while(!zeroDegree.isEmpty()){
			// Iterator loop through collections
			// https://www.w3schools.com/java/java_iterator.asp#:~:text=An%20Iterator%20is%20an%20object,util%20package.
			// https://www.tutorialspoint.com/how-to-use-iterator-in-java
			// traverse each and every element in the collection or you can even remove
			// Hashset remove -> https://www.geeksforgeeks.org/hashset-remove-method-in-java/
			Iterator<Integer> it = zeroDegree.iterator();
			// take a node n from startSet
			int course = it.next();
			zeroDegree.remove(course);
			// for each node m with an edge e from n to m;
			for(int[] pre : prerequisites){
				if(course == pre[1]){
					// mark e as removed
					indegree[pre[0]]--;
					// if m does not have incoming edges any more:
					if(indegree[pre[0]] == 0){
						// add m into startSet
						zeroDegree.add(pre[0]);
					}
				}
			}
		}
		// check if there still edges in the graph
		for(int num : indegree){
			// if there is mean the graph has a cycle
			if(num != 0){
				return false;
			}
		}
		return true;
    }
}

/*
Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
*/

//https://leetcode.com/problems/course-schedule-ii/
//210
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
		// check how many node it can point to
		for(int[] pre : prerequisites){
			indegree[pre[0]]++;
		}
		// starting set
		Set<Integer> zeroDegree = new HashSet();
		for(int i = 0; i < numCourses; i++){
			if(indegree[i] == 0){
				zeroDegree.add(i);
			}
		}
		// check if valid deck
		if(zeroDegree.isEmpty()){
			return new int[]{};
		}
        int[] order = new int[numCourses];
        int i = 0;
		while(!zeroDegree.isEmpty()){
			Iterator<Integer> it = zeroDegree.iterator();
			int course = it.next();
            order[i++] = course;
			zeroDegree.remove(course);
			for(int[] pre : prerequisites){
				// remove an edge
				if(course == pre[1]){
					indegree[pre[0]]--;
					if(indegree[pre[0]] == 0){
						zeroDegree.add(pre[0]);
					}
				}
			}
		}
		// check if there still edges in the graph
		for(int num : indegree){
			// if there is mean the graph has a cycle
			if(num != 0){
				return  new int[]{};
			}
		}
		return order;
    }
}
/*
Input: numCourses = 2, prerequisites = [[1,0]]
Output: [0,1]
Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
Output: [0,2,1,3]
*/

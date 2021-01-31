
//https://www.youtube.com/watch?v=IfElFyaEV8s
//LeetCode 1046: Last Stone Weight - Interview Prep Ep 40
//https://leetcode.com/problems/last-stone-weight/

class Solution {
	// Time: O(nlogn)
	// Space: O(n)
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a,b) -> b - a);
		// https://www.geeksforgeeks.org/priorityqueue-offer-method-in-java/
		// offer same as add, with criteria
		for(int num : stones){
			maxHeap.offer(num);
		}
		while(!maxHeap.isEmpty()){
			if(maxHeap.size() >= 2){
				// The peek() method only retrieved the element at the head but the poll() also removes the element along with the retrieval
				// https://www.geeksforgeeks.org/priorityqueue-poll-method-in-java/
				maxHeap.offer(maxHeap.poll() - maxHeap.poll());
			} else {
				return maxHeap.poll();
			}
		}
		return -1;
    }
}

/*
Input: [2,7,4,1,8,1]
Output: 1
Explanation: 
We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of last stone.
*/

//https://www.youtube.com/watch?v=Llse1tImXQA
//LeetCode 23: Merge k Sorted Lists - Interview Prep Ep 26
//https://leetcode.com/problems/merge-k-sorted-lists/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
 // n nodes in all k sorted lists
 // Time: O(nlog(k)) -> log(k) Priority Queue, n number of link list looped
 // Space: O(k) -> only head list node used
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
		// sort the queue by smallest first
        PriorityQueue<ListNode> heap = new PriorityQueue((Comparator<ListNode>)(o1,o2)-> o1.val - o2.val);
		for(ListNode head : lists){
			if(head != null){
				heap.offer(head);
			}
		}
		
		ListNode pre = new ListNode(-1);
		ListNode tmp = pre;
		// extract the first queue in the queue
		// then extract the first number
		// add the remaining back to the queue which will
		// sort by the first number in ascending order
		// repeat till the queue is empty
		while(!heap.isEmpty()){
			ListNode curr = heap.poll();
			tmp.next = new ListNode(curr.val);
			if(curr.next != null){
				// add to the queue 
				heap.offer(curr.next);
			}
			tmp = tmp.next;
		}
		// pre = -1
		// pre.next, start of the smallest number
		return pre.next;
    }
}

/*
Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6
*/











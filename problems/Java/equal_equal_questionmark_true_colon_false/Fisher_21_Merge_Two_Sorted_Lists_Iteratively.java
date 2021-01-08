
//https://www.youtube.com/watch?v=N8WTaSSivEI
//LeetCode 21: Merge Two Sorted Lists ITERATIVELY - Interview Prep Ep 61
//https://leetcode.com/problems/merge-two-sorted-lists/

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
 // save memory because no core stack for recursive
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		// prev is empty start
		ListNode prev = new ListNode(-1);
		ListNode curr = prev;
		// if both is not empty
		while(l1 != null && l2 != null){
			if(l1.val < l2.val){
				curr.next = l1;
				l1 = l1.next;
			} else {
				curr.next = l2;
				l2 = l2.next;
			}
			curr = curr.next;
		}
		// set the remaining 
		curr.next = l1 == null ? l2 : l1;
		// prev is empty hence need to go to next where the actual start value is
		return prev.next;
	}
}

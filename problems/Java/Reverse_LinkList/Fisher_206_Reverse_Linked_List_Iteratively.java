
//https://www.youtube.com/watch?v=N_Y12-5oa-w
//LeetCode 206: Reverse Linked List ITERATIVELY - Interview Prep Ep 59
//https://leetcode.com/problems/reverse-linked-list/


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
 class Solution {
    public ListNode reverseList(ListNode head) {
		ListNode prev = null;
		ListNode curr = head;
		while(curr != null){
			// a -> b -> c -> d
			// <curr> value is a
			// hold the current head next value
			ListNode next = curr.next;
			// <next> value is b
			
			// set next value as new head
			curr.next = prev;
			// <curr.next> become null
			
			// set newhead as head, keep moving right
			prev = curr;
			// <prev> become a
			
			// move the incoming head to next value and repeat
			curr = next;
			// <curr> become b
			// a -> null 	b->c->d
		}
		// return prev the last node since last.next is null 
		return prev;
	}
 }
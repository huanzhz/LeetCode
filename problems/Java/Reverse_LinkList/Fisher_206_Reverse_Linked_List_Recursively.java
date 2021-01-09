
//https://www.youtube.com/watch?v=W-EfGB0E_ao
//LeetCode 206: Reverse Linked List RECURSIVELY - Interview Prep Ep 60
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
        return reverse(head, null);
    }
	
	private ListNode reverse(ListNode head, ListNode newHead){
		if(head == null){
			return newHead;
		}
		
		// a -> b -> c -> d
		// hold the current head next value 
		ListNode next = head.next;
		// <next> value is b
		
		// set next value as new head
		head.next = newHead;
		// <head.next> become null from the first call
		
		// set newhead as head, keep moving right
		newHead = head;
		// <newHead> become a
		
		// move the incoming head to next value and repeat
		head = next;
		// <head> become b
		
		// loop till the last node and it pop back
		return reverse(head,newHead);
	}
}


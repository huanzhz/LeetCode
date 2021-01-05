
//https://www.youtube.com/watch?v=bOGh_3MTrdE
//LeetCode 234: Palindrome Linked List - Interview Prep Ep 63
//https://leetcode.com/problems/palindrome-linked-list/

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
    public boolean isPalindrome(ListNode head) {
        if(head == null){
			return true;
		}
	
		ListNode fast = head;
		ListNode slow = head;
		
		while(fast.next != null && fast.next.next != null){
			fast = fast.next.next;
			slow = slow.next;
		}
		
		ListNode secondHalfHead = reverse(slow.next);
		ListNode firstHalfHead = head;
		
		while(secondHalfHead != null && firstHalfHead != null){
			// found that they are not palindrome
			if(firstHalfHead.val != secondHalfHead.val){
				return false;
			}
			secondHalfHead = secondHalfHead.next;
			firstHalfHead = firstHalfHead.next;
		}
		// finish both half
		return true;
	}
	
	// reverse Link list
	private ListNode reverse(ListNode head){
		// empty pointer <newHead>
		ListNode newHead = null;
		while(head != null){
			// a -> b -> c -> d
			// <head> value is a
			// hold the current head next value
			ListNode next = head.next;
			// <next> value is b
			
			// set next value as new head 
			head.next = newHead;
			// <head.next> become null
			
			// set newhead as head, keep moving right
			newHead = head;
			// <newHead> become a
			
			// move the incoming head to next value and repeat
			head = next;
			// <head> become b
			// a -> null 	b->c->d
			// second loop b->a->null  c->d
		}
		return newHead;
	}
}
/*
Input: 1->2
Output: false
Input: 1->2->2->1
Output: true
*/
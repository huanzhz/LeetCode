
//https://www.youtube.com/watch?v=Kka8VgyFZfc
//LeetCode 19: Remove Nth Node From End of List - Interview Prep Ep 58
//https://leetcode.com/problems/remove-nth-node-from-end-of-list/

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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode slow = dummy;
		ListNode fast = dummy;
		// -1->a->b->c->d->null
		// removing c where slow pointer at b and fast pointer at d
		while(fast.next != null){
			fast = fast.next;
			// the range between fast and slow pointer
			if(n-- <= 0){
				slow = slow.next;
			}
		}
		// set b point to d
		slow.next = slow.next.next;
		// a->b->d->null
		return dummy.next;
    }
}
/*
Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]
Input: head = [1,2], n = 1
Output: [1]
*/




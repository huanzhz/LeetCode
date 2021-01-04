
//https://www.youtube.com/watch?v=agkyC-rbgKM
//LeetCode 141: Linked List Cycle - Interview Prep Ep 64
//https://leetcode.com/problems/linked-list-cycle/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
		ListNode fast = head;
		while(fast != null && fast.next != null){
			fast = fast.next.next;
			slow = slow.next;
			// there is a cycle hence fast pointer and slow point will met
			if(slow == fast){
				return true;
			}
		}
		return false;
    }
}

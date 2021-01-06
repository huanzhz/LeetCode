
//https://www.youtube.com/watch?v=bdWOmYL5d1g
//LeetCode 21: Merge Two Sorted Lists RECURSIVELY - Interview Prep Ep 62
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
 // stack -> time complexity 
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		// reach the end of recursion for each linklist
        if(l1 == null){
			return l2;
		}
		if(l2 == null){
			return l1;
		}
		
		if(l1.val < l2.val){
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		} else {
			l2.next = mergeTwoLists(l1.next, l2);
			return l2;
		}
    }
}

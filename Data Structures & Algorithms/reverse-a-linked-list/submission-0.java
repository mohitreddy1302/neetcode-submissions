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

        // Previous node starts as null
        ListNode prev = null;

        // Current node starts at the head
        ListNode curr = head;

        // Temporary node used to store the next node
        ListNode next = null;

        while (curr != null) {

            // Save the next node before changing the link
            next = curr.next;

            // Reverse the current node's pointer
            curr.next = prev;

            // Move prev one step forward
            prev = curr;

            // Move curr one step forward
            curr = next;
        }

        // prev is the new head of the reversed list
        return prev;
    }
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {

        /*
         * Check whether at least k nodes are available
         * in the current group.
         */
        ListNode temp = head;
        int count = 0;

        while (count < k) {

            // Fewer than k nodes remain.
            // Leave them unchanged.
            if (temp == null) {
                return head;
            }

            temp = temp.next;
            count++;
        }

        /*
         * temp now points to the first node of the next group.
         * Recursively reverse all remaining groups.
         *
         * Important: use temp, not temp.next.
         */
        ListNode nextGroupHead = reverseKGroup(temp, k);

        /*
         * Reverse the current group of k nodes.
         */
        ListNode previous = nextGroupHead;
        ListNode current = head;
        count = 0;

        while (count < k) {

            // Save the next node before changing the link.
            ListNode next = current.next;

            // Reverse the current node's link.
            current.next = previous;

            // Move previous forward.
            previous = current;

            // Move current forward.
            current = next;

            count++;
        }

        /*
         * previous is now the first node of the reversed group.
         */
        return previous;
    }
}
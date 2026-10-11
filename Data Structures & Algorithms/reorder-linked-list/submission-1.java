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
    public void reorderList(ListNode head) {

        // If the list has zero, one, or two nodes,
        // no reordering is necessary.
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }

        /*
         * Step 1: Find the middle of the linked list.

         * slow moves one step.
         * fast moves two steps.

         * When fast reaches the end, slow is at
         * the end of the first half.
         */
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        /*
         * Split the list into two halves.

         * Example:
         * First half:  2 → 4 → 6
         * Second half: 8 → 10
         */
        ListNode second = slow.next;
        slow.next = null;

        /*
         * Step 2: Reverse the second half.
         *
         * Before:
         * 8 → 10
         *
         * After:
         * 10 → 8
         */
        second = reverse(second);

        /*
         * Step 3: Merge the two halves alternately.

         * Take one node from the first half,
         * then one node from the reversed second half.
         */
        ListNode first = head;

        while (second != null) {

            // Save the next nodes before changing the links
            ListNode firstNext = first.next;
            ListNode secondNext = second.next;

            // Connect one node from the first half to second
            first.next = second;

            // Connect the second node back to the remaining first half
            second.next = firstNext;

            // Move both pointers forward
            first = firstNext;
            second = secondNext;
        }
    }

    /*
     * Reverses a linked list and returns its new head.
     */
    private ListNode reverse(ListNode head) {

        ListNode previous = null;
        ListNode current = head;

        while (current != null) {

            // Save the next node
            ListNode next = current.next;

            // Reverse the current pointer
            current.next = previous;

            // Move previous forward
            previous = current;

            // Move current forward
            current = next;
        }

        return previous;
    }
}
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
    public boolean hasCycle(ListNode head) {

        /*
         * slow moves one node at a time.
         * fast moves two nodes at a time.
         */
        ListNode slow = head;
        ListNode fast = head;

        /*
         * We must check both fast and fast.next
         * before moving fast two steps.
         */
        while (fast != null && fast.next != null) {

            // Move slow by one node
            slow = slow.next;

            // Move fast by two nodes
            fast = fast.next.next;

            /*
             * If slow and fast meet, the linked list
             * contains a cycle.
             */
            if (slow == fast) {
                return true;
            }
        }

        /*
         * If fast reaches null, the list ends normally,
         * so there is no cycle.
         */
        return false;
    }
}
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        /*
         * Create a dummy node.

         * This node is only a temporary starting point.
         * It makes it easier to build the merged list.
         */
        ListNode dummy = new ListNode();

        /*
         * tail always points to the last node
         * in the merged list.
         */
        ListNode tail = dummy;

        /*
         * Continue while both lists still have nodes.
         */
        while (list1 != null && list2 != null) {

            /*
             * Compare the current nodes of both lists.

             * Attach the smaller node to the merged list.
             */
            if (list1.val < list2.val) {

                // Attach list1's current node
                tail.next = list1;

                // Move list1 to its next node
                list1 = list1.next;
            } else {

                // Attach list2's current node
                tail.next = list2;

                // Move list2 to its next node
                list2 = list2.next;
            }

            /*
             * Move tail to the node we just attached.
             */
            tail = tail.next;
        }

        /*
         * At this point, one list may still contain nodes.

         * Since the remaining part is already sorted,
         * attach it directly to the merged list.
         */
        if (list1 != null) {
            tail.next = list1;
        } else {
            tail.next = list2;
        }

        /*
         * dummy itself is not part of the answer.
         * The actual merged list begins at dummy.next.
         */
        return dummy.next;
    }
}
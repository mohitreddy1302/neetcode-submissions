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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // Dummy node helps us easily build the result list.
        ListNode dummy = new ListNode(0);

        // current points to the last node in the result list.
        ListNode current = dummy;

        int carry = 0;

        // Continue while there are digits left or a carry remains.
        while (l1 != null || l2 != null || carry != 0) {

            // If a list is finished, treat its digit as 0.
            int digit1 = (l1 != null) ? l1.val : 0;
            int digit2 = (l2 != null) ? l2.val : 0;

            // Add both digits and the carry from the previous step.
            int sum = digit1 + digit2 + carry;

            // Create a new node containing the current digit.
            current.next = new ListNode(sum % 10);

            // Move current to the newly created node.
            current = current.next;

            // Calculate the carry for the next step.
            carry = sum / 10;

            // Move l1 forward if it still has nodes.
            if (l1 != null) {
                l1 = l1.next;
            }

            // Move l2 forward if it still has nodes.
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        // Skip the dummy node and return the actual result list.
        return dummy.next;
    }
}
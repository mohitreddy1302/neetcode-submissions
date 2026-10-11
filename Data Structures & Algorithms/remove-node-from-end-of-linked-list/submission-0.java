class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        int size = 0;
        ListNode current = head;

        // Find the length of the list
        while (current != null) {
            size++;
            current = current.next;
        }

        // If removing the head
        if (n == size) {
            return head.next;
        }

        // Find the node before the node we want to remove
        int indexToSearch = size - n;

        ListNode previous = head;
        int i = 1;

        while (i < indexToSearch) {
            previous = previous.next;
            i++;
        }

        // Skip the target node
        previous.next = previous.next.next;

        return head;
    }
}
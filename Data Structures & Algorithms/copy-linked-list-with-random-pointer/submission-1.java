
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {

        // If the original list is empty, return null.
        if (head == null) {
            return null;
        }

        /*
         * This map connects each original node to its copied node.
         *
         * Original node  ->  Copied node
         *       A        ->       A'
         */
        HashMap<Node, Node> map = new HashMap<>();

        Node current = head;

        // First pass: create a copy of every node.
        while (current != null) {
            Node copy = new Node(current.val);

            // Store the relationship between original and copied nodes.
            map.put(current, copy);

            current = current.next;
        }

        current = head;

        // Second pass: connect next and random pointers.
        while (current != null) {

            // Get the copied version of the current original node.
            Node copy = map.get(current);

            /*
             * current.next may be null.
             * map.get(null) returns null, so this works correctly.
             */
            copy.next = map.get(current.next);

            /*
             * current.random may also be null.
             * Otherwise, get the copied node that current.random points to.
             */
            copy.random = map.get(current.random);

            current = current.next;
        }

        // Return the copied version of the original head.
        return map.get(head);
    }
}
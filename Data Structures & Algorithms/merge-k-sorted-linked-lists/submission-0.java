/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *
 *     ListNode() {}
 *     ListNode(int val) {
 *         this.val = val;
 *     }
 *
 *     ListNode(int val, ListNode next) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */

class Solution {

    public ListNode mergeKLists(ListNode[] lists) {

        // If there are no linked lists, return null.
        if (lists == null || lists.length == 0) {
            return null;
        }

        /*
         * Merge all lists using divide and conquer.
         *
         * We start from index 0 and end at index lists.length - 1.
         */
        return mergeRange(0, lists.length - 1, lists);
    }

    /*
     * Recursively merges all lists between start and end.
     */
    private ListNode mergeRange(
            int start,
            int end,
            ListNode[] lists) {

        /*
         * If start == end, there is only one list.
         * That list is already sorted, so return its head.
         */
        if (start == end) {
            return lists[start];
        }

        /*
         * Find the middle index.
         *
         * This formula avoids possible integer overflow.
         */
        int middle = start + (end - start) / 2;

        /*
         * Recursively merge the left half of the lists.
         */
        ListNode leftList = mergeRange(start, middle, lists);

        /*
         * Recursively merge the right half of the lists.
         */
        ListNode rightList = mergeRange(middle + 1, end, lists);

        /*
         * Merge the two already-sorted lists.
         */
        return mergeTwoLists(leftList, rightList);
    }

    /*
     * Merges two sorted linked lists.
     */
    private ListNode mergeTwoLists(
            ListNode list1,
            ListNode list2) {

        // If one list is empty, return the other list.
        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        /*
         * If list1's value is smaller, keep list1's node
         * and recursively merge the rest of list1 with list2.
         */
        if (list1.val <= list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        }

        /*
         * Otherwise, keep list2's node
         * and recursively merge list1 with the rest of list2.
         */
        list2.next = mergeTwoLists(list1, list2.next);
        return list2;
    }
}
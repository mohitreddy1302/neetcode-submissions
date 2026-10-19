/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int goodNodes(TreeNode root) {

        /*
         * The root is always good because there are
         * no previous nodes on its path.
         */
        return countGoodNodes(root, root.val);
    }

    private int countGoodNodes(TreeNode root, int maxSeen) {

        /*
         * If there is no node, it contributes 0 good nodes.
         */
        if (root == null) {
            return 0;
        }

        int count = 0;

        /*
         * A node is good if its value is greater than
         * or equal to the greatest value seen before it
         * on the path from the root.
         */
        if (root.val >= maxSeen) {
            count = 1;
        }

        /*
         * Update the maximum value before moving
         * to the children.
         */
        int newMax = Math.max(maxSeen, root.val);

        /*
         * Recursively count good nodes in the left subtree.
         */
        count += countGoodNodes(root.left, newMax);

        /*
         * Recursively count good nodes in the right subtree.
         */
        count += countGoodNodes(root.right, newMax);

        /*
         * Return the total number of good nodes
         * found in this subtree.
         */
        return count;
    }
}
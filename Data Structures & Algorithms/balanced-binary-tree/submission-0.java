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
    public boolean isBalanced(TreeNode root) {

        /*
         * The helper returns:
         *
         * - The height of the subtree if it is balanced.
         * -1 if the subtree is not balanced.
         */
        return height(root) != -1;
    }

    private int height(TreeNode root) {

        /*
         * An empty tree is balanced
         * and has height 0.
         */
        if (root == null) {
            return 0;
        }

        /*
         * Find the height of the left subtree.
         */
        int leftHeight = height(root.left);

        /*
         * If the left subtree is unbalanced,
         * immediately return -1.
         */
        if (leftHeight == -1) {
            return -1;
        }

        /*
         * Find the height of the right subtree.
         */
        int rightHeight = height(root.right);

        /*
         * If the right subtree is unbalanced,
         * immediately return -1.
         */
        if (rightHeight == -1) {
            return -1;
        }

        /*
         * Check whether the current node is balanced.
         *
         * The two subtree heights can differ by at most 1.
         */
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        /*
         * The current subtree is balanced.
         * Return its height to the parent node.
         */
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
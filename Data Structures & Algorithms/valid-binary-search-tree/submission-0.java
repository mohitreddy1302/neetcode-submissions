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
    public boolean isValidBST(TreeNode root) {

        /*
         * Initially, the root can contain any integer value.
         *
         * We use long limits because TreeNode values can be
         * as small as -1,000,000,000 and as large as 1,000,000,000.
         */
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean validate(TreeNode root, long lowerBound, long upperBound) {

        /*
         * An empty tree is valid.
         */
        if (root == null) {
            return true;
        }

        /*
         * The current node must be strictly between
         * the lower and upper bounds.
         *
         * Strictly means:
         * root.val > lowerBound
         * root.val < upperBound
         */
        if (root.val <= lowerBound || root.val >= upperBound) {
            return false;
        }

        /*
         * For the left subtree:
         * every value must be smaller than root.val.
         *
         * The lower bound remains the same,
         * but the upper bound becomes root.val.
         */
        boolean leftIsValid =
                validate(root.left, lowerBound, root.val);

        /*
         * For the right subtree:
         * every value must be greater than root.val.
         *
         * The lower bound becomes root.val,
         * but the upper bound remains the same.
         */
        boolean rightIsValid =
                validate(root.right, root.val, upperBound);

        /*
         * Both subtrees must be valid.
         */
        return leftIsValid && rightIsValid;
    }
}
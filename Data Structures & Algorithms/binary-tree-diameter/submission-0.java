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

    /*
     * This method calculates the height of a tree.
     *
     * Height means the number of nodes
     * along the longest path from the current node
     * down to a leaf.
     */
    private int height(TreeNode root) {

        // An empty tree has height 0.
        if (root == null) {
            return 0;
        }

        // Find the height of the left subtree.
        int leftHeight = height(root.left);

        // Find the height of the right subtree.
        int rightHeight = height(root.right);

        /*
         * The height of the current node is:
         *
         * 1 for the current node
         * plus the height of its deeper subtree.
         */
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public int diameterOfBinaryTree(TreeNode root) {

        // An empty tree has diameter 0.
        if (root == null) {
            return 0;
        }

        /*
         * Find the best diameter entirely inside
         * the left subtree.
         */
        int leftDiameter = diameterOfBinaryTree(root.left);

        /*
         * Find the best diameter entirely inside
         * the right subtree.
         */
        int rightDiameter = diameterOfBinaryTree(root.right);

        /*
         * Find the diameter passing through the current root.
         *
         * The path goes:
         *
         * deepest node in the left subtree
         *       -> current root
         *       -> deepest node in the right subtree
         *
         * LeetCode measures diameter using edges,
         * so we add the two subtree heights.
         */
        int currentDiameter = height(root.left) + height(root.right);

        /*
         * The answer is the largest of:
         *
         * 1. Diameter in the left subtree
         * 2. Diameter in the right subtree
         * 3. Diameter passing through the current root
         */
        return Math.max(
            currentDiameter,
            Math.max(leftDiameter, rightDiameter)
        );
    }
}
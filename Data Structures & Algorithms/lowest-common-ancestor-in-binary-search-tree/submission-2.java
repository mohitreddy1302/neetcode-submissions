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
    public TreeNode lowestCommonAncestor(TreeNode root,
                                         TreeNode p,
                                         TreeNode q) {

        /*
         * If we reach an empty position,
         * neither p nor q was found here.
         */
        if (root == null) {
            return null;
        }

        /*
         * If the current node is p or q,
         * return the current node.
         *
         * A node can be an ancestor of itself.
         */
        if (root == p || root == q) {
            return root;
        }

        /*
         * Search for p and q in the left subtree.
         */
        TreeNode leftLCA = lowestCommonAncestor(root.left, p, q);

        /*
         * Search for p and q in the right subtree.
         */
        TreeNode rightLCA = lowestCommonAncestor(root.right, p, q);

        /*
         * If both sides return a node,
         * one target was found on the left
         * and the other target was found on the right.
         *
         * Therefore, the current root is their LCA.
         */
        if (leftLCA != null && rightLCA != null) {
            return root;
        }

        /*
         * If only the left side found a target or an LCA,
         * pass that result upward.
         */
        if (leftLCA != null) {
            return leftLCA;
        }

        /*
         * Otherwise, return whatever was found on the right.
         *
         * This may be q, p, or the LCA found deeper
         * in the right subtree.
         */
        return rightLCA;
    }
}
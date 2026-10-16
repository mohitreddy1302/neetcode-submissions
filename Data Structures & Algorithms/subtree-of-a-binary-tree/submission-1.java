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

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        /*
         * An empty tree is considered a subtree
         * of any tree.
         */
        if (subRoot == null) {
            return true;
        }

        /*
         * If the main tree is empty but subRoot is not,
         * then subRoot cannot be found.
         */
        if (root == null) {
            return false;
        }

        /*
         * Check whether the tree starting at the current root
         * is exactly the same as subRoot.
         */
        if (isSameTree(root, subRoot)) {
            return true;
        }

        /*
         * If the current root is not the starting point,
         * search for subRoot in both subtrees.
         */
        return isSubtree(root.left, subRoot)
            || isSubtree(root.right, subRoot);
    }

    private boolean isSameTree(TreeNode p, TreeNode q) {

        /*
         * If both nodes are null, they match.
         */
        if (p == null && q == null) {
            return true;
        }

        /*
         * If only one node is null, the structures differ.
         */
        if (p == null || q == null) {
            return false;
        }

        /*
         * If the values differ, the trees are not the same.
         */
        if (p.val != q.val) {
            return false;
        }

        /*
         * Compare corresponding left subtrees
         * and corresponding right subtrees.
         */
        return isSameTree(p.left, q.left)
            && isSameTree(p.right, q.right);
    }
}
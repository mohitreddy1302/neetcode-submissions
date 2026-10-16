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
    public boolean isSameTree(TreeNode p, TreeNode q) {

        /*
         * If both nodes are null, they match.
         */
        if (p == null && q == null) {
            return true;
        }

        /*
         * If only one node is null, the structures are different.
         */
        if (p == null || q == null) {
            return false;
        }

        /*
         * If the values are different, the trees are not the same.
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
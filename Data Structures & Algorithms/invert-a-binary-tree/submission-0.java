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
    public TreeNode invertTree(TreeNode root) {

        /*
         * If the tree is empty, there is nothing to invert.
         */
        if (root == null) {
            return null;
        }

        /*
         * Save the left subtree temporarily.
         *
         * We need to save it because after swapping,
         * root.left will point to the original right subtree.
         */
        TreeNode temporary = root.left;

        /*
         * Swap the left and right children.
         */
        root.left = root.right;
        root.right = temporary;

        /*
         * Recursively invert the left subtree.
         */
        invertTree(root.left);

        /*
         * Recursively invert the right subtree.
         */
        invertTree(root.right);

        /*
         * Return the root of the inverted tree.
         */
        return root;
    }
}
/*If the current node is null, return.
Swap its left and right pointers.
Recursively do the same for its left child.
Recursively do the same for its right child.
Return the original root.*/
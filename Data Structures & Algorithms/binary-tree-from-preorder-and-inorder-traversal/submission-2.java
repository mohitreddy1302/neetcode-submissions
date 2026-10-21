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

    // Points to the next unread value in preorder.
    private int preorderIndex = 0;

    // Stores each value's index in the inorder array.
    private Map<Integer, Integer> inorderIndex = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        // Reset the index in case the method is called again.
        preorderIndex = 0;
        inorderIndex.clear();

        /*
         * Store the position of every value in inorder.
         * This allows us to find the root position in O(1) time.
         */
        for (int i = 0; i < inorder.length; i++) {
            inorderIndex.put(inorder[i], i);
        }

        /*
         * Initially, the whole inorder array belongs
         * to the complete tree.
         */
        return build(preorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int left, int right) {

        /*
         * If the range is empty, there is no subtree.
         */
        if (left > right) {
            return null;
        }

        /*
         * Preorder follows:
         *
         * Root → Left subtree → Right subtree
         *
         * Therefore, the next unread preorder value
         * is the root of the current subtree.
         */
        int rootValue = preorder[preorderIndex++];

        // Create the current root node.
        TreeNode root = new TreeNode(rootValue);

        /*
         * Find the root's position in inorder.
         *
         * Inorder follows:
         *
         * Left subtree → Root → Right subtree
         */
        int middle = inorderIndex.get(rootValue);

        /*
         * Values before middle belong to the left subtree.
         */
        root.left = build(preorder, left, middle - 1);

        /*
         * Values after middle belong to the right subtree.
         */
        root.right = build(preorder, middle + 1, right);

        return root;
    }
}
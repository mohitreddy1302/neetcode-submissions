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
    public List<Integer> rightSideView(TreeNode root) {

        // Stores the rightmost visible node from each level.
        List<Integer> result = new ArrayList<>();

        // If the tree is empty, return an empty list.
        if (root == null) {
            return result;
        }

        // Queue is used for level-order traversal.
        Queue<TreeNode> queue = new LinkedList<>();

        // Start the traversal with the root.
        queue.offer(root);

        while (!queue.isEmpty()) {

            /*
             * Store the number of nodes in the current level.
             * This helps us know which node is the last one
             * in this level.
             */
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {

                // Remove the next node from the queue.
                TreeNode current = queue.poll();

                /*
                 * If this is the last node of the current level,
                 * it is visible from the right side.
                 */
                if (i == levelSize - 1) {
                    result.add(current.val);
                }

                /*
                 * Add children for the next level.
                 * Add left first and right second so that
                 * the rightmost node is processed last.
                 */
                if (current.left != null) {
                    queue.offer(current.left);
                }

                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
        }

        return result;
    }
}
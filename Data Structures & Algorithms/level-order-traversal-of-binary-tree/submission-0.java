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
    public List<List<Integer>> levelOrder(TreeNode root) {

        // This will store the final answer.
        List<List<Integer>> result = new ArrayList<>();

        // If the tree is empty, return an empty list.
        if (root == null) {
            return result;
        }

        /*
         * The queue stores nodes that still need to be processed.
         * We use ArrayDeque because it efficiently supports queue operations.
         */
        Queue<TreeNode> queue = new ArrayDeque<>();

        // Start with the root node.
        queue.offer(root);

        /*
         * Continue while there are nodes waiting in the queue.
         */
        while (!queue.isEmpty()) {

            /*
             * At this moment, queue.size() tells us
             * how many nodes belong to the current level.
             */
            int levelSize = queue.size();

            // Store values belonging to this one level.
            List<Integer> currentLevel = new ArrayList<>();

            /*
             * Process exactly the nodes from the current level.
             */
            for (int i = 0; i < levelSize; i++) {

                // Remove the front node from the queue.
                TreeNode current = queue.poll();

                // Add its value to the current level.
                currentLevel.add(current.val);

                /*
                 * Add the children to the queue.
                 * They will be processed in the next level.
                 */
                if (current.left != null) {
                    queue.offer(current.left);
                }

                if (current.right != null) {
                    queue.offer(current.right);
                }
            }

            // Add the completed level to the final answer.
            result.add(currentLevel);
        }

        return result;
    }
}
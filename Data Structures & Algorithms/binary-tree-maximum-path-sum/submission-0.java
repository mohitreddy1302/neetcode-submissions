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

    // Best path sum found anywhere in the tree so far.
    // Starts at the smallest possible int because node values can all be negative.
    private int maxSum;

    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        maxGain(root);   // the return value is not needed here; maxSum is updated as a side effect
        return maxSum;
    }

    // Returns the best sum of a path that starts at `node` and goes DOWN into
    // at most one of its subtrees. The caller can extend this path upward to its parent.
    private int maxGain(TreeNode node) {
        // An empty subtree contributes 0 (we can just not use it)
        if (node == null) {
            return 0;
        }

        // Best downward path from each child. If a child's best path is negative,
        // we treat it as 0, which means "don't include that side at all."
        int leftGain  = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);

        // Path that passes THROUGH this node and uses BOTH sides.
        // This path cannot continue to the parent, so it only updates the global answer.
        int pathThroughNode = node.val + leftGain + rightGain;
        maxSum = Math.max(maxSum, pathThroughNode);

        // Path that goes UP to the parent can use only ONE side,
        // because a path cannot branch and then also connect to the parent.
        return node.val + Math.max(leftGain, rightGain);
    }
}
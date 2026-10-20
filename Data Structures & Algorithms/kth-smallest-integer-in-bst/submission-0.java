class Solution {

    private int count = 0;
    private int answer = 0;

    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return answer;
    }

    private void inorder(TreeNode root, int k) {

        // Stop if there is no node.
        if (root == null) {
            return;
        }

        // Visit the left subtree first.
        inorder(root.left, k);

        /*
         * If the answer was already found in the left subtree,
         * stop before processing more nodes.
         */
        if (count >= k) {
            return;
        }

        // Process the current node.
        count++;

        // The kth visited node is the kth smallest value.
        if (count == k) {
            answer = root.val;
            return;
        }

        // Visit the right subtree.
        inorder(root.right, k);
    }
}
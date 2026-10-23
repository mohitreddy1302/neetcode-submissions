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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    // Preorder traversal. Writes "N" for each null child.
    private void buildString(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("N,");
            return;
        }
        sb.append(node.val).append(",");
        buildString(node.left, sb);
        buildString(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] tokens = data.split(",");
        int[] idx = {0};   // shared position in the token array
        return build(tokens, idx);
    }

    // Reads tokens in the same preorder order to rebuild the tree.
    private TreeNode build(String[] tokens, int[] idx) {
        String token = tokens[idx[0]++];
        if (token.equals("N")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(token));
        node.left = build(tokens, idx);
        node.right = build(tokens, idx);
        return node;
    }
}
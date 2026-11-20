

/*class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/
class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;

        // original node -> its clone
        Map<Node, Node> map = new HashMap<>();
        return dfs(node, map);
    }

    private Node dfs(Node node, Map<Node, Node> map) {
        // Already cloned: return the existing copy (this also breaks cycles)
        if (map.containsKey(node)) {
            return map.get(node);
        }

        // Create the copy and register it BEFORE visiting neighbours
        Node copy = new Node(node.val);
        map.put(node, copy);

        // Clone each neighbour and attach it to our copy
        for (Node nei : node.neighbors) {
            copy.neighbors.add(dfs(nei, map));
        }

        return copy;
    }
}
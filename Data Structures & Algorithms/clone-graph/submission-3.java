

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
/*If the node isn’t in the map, create its copy (with the same val, but an empty neighbors list) and store it in the map.
Go through the original node’s neighbours. For each one, make a recursive call. That call does the same steps for the neighbour: copy it if it’s new, then recurse into its neighbours. Each call returns its finished copy only after its own neighbours are done.
Add each returned copy to the current copy’s neighbors list.
Return the current copy to the caller.*/
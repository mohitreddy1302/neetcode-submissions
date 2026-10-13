
class LRUCache {

    /*
     * Each node stores:
     * - key
     * - value
     * - previous node
     * - next node
     */
    private class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    // Stores key -> corresponding linked-list node.
    private Map<Integer, Node> map;

    // Dummy nodes that mark the two ends of the doubly linked list.
    private Node head;
    private Node tail;

    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();

        /*
         * The list will look like:
         *
         * head ⇄ most recently used ... least recently used ⇄ tail
         *
         * head and tail are dummy nodes.
         * They do not store actual cache data.
         */
        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
    }

    /*
     * Adds a node immediately after head.
     *
     * The node after head is always the most recently used node.
     */
    private void addNode(Node node) {

        Node firstRealNode = head.next;

        // Connect head and the new node.
        head.next = node;
        node.prev = head;

        // Connect the new node and the old first node.
        node.next = firstRealNode;
        firstRealNode.prev = node;
    }

    /*
     * Removes a node from its current position.
     */
    private void removeNode(Node node) {

        Node previousNode = node.prev;
        Node nextNode = node.next;

        // Skip over the node being removed.
        previousNode.next = nextNode;
        nextNode.prev = previousNode;
    }

    public int get(int key) {

        // If the key does not exist, return -1.
        if (!map.containsKey(key)) {
            return -1;
        }

        // Find the node in O(1) time using the HashMap.
        Node node = map.get(key);

        // Save the value before changing its position.
        int answer = node.value;

        /*
         * Since this key was used, it becomes the most recently used.
         */
        removeNode(node);
        addNode(node);

        return answer;
    }

    public void put(int key, int value) {

        /*
         * If the key already exists:
         * - update its value
         * - move it to the most recently used position
         */
        if (map.containsKey(key)) {
            Node existingNode = map.get(key);

            existingNode.value = value;

            removeNode(existingNode);
            addNode(existingNode);

            return;
        }

        /*
         * If the cache is full, remove the least recently used node.
         *
         * The least recently used real node is tail.prev.
         */
        if (map.size() == capacity) {
            Node leastRecentlyUsed = tail.prev;

            removeNode(leastRecentlyUsed);
            map.remove(leastRecentlyUsed.key);
        }

        // Create a new node for the key-value pair.
        Node newNode = new Node(key, value);

        // Add it to the map.
        map.put(key, newNode);

        // A newly inserted node is the most recently used.
        addNode(newNode);
    }
}
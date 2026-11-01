class WordDictionary {

    // One node in the trie: represents one character position in some word
    private static class TrieNode {
        // children[0] is for 'a', children[1] for 'b', ..., children[25] for 'z'.
        // A null entry means no word continues with that letter from this node.
        TrieNode[] children = new TrieNode[26];

        // true only if a complete word ends exactly at this node
        boolean isWord = false;
    }

    // The starting point of the trie. It has no letter of its own.
    private TrieNode root;

    // Called once when the object is created
    public WordDictionary() {
        // Create the empty root node. Nothing is stored yet.
        root = new TrieNode();
    }

    // Adds a word to the trie, one letter at a time
    public void addWord(String word) {
        // curr is the node we are standing on. We start at the root.
        TrieNode curr = root;

        // i is the position of the letter we are currently reading (0, 1, 2, ...)
        for (int i = 0; i < word.length(); i++) {
            // The letter at position i, e.g. 'd' in "dog"
            char c = word.charAt(i);

            // Convert the letter to an array index: 'a' -> 0, 'b' -> 1, ..., 'z' -> 25
            int idx = c - 'a';

            // If no child exists for this letter yet, create the node for it
            if (curr.children[idx] == null) {
                curr.children[idx] = new TrieNode();
            }

            // Move down to the child for this letter
            curr = curr.children[idx];
        }

        // We finished the word, so the node we are on marks the end of a real word
        curr.isWord = true;
    }

    // Returns true if some stored word matches the pattern, where '.' matches any one letter
    public boolean search(String word) {
        // Begin matching at position 0 of the pattern, starting from the root
        return dfs(word, 0, root);
    }

    // Tries to match the pattern from position i onward, starting at node
    // word: the search pattern, e.g. ".ad"
    // i: the position in the pattern we are currently matching
    // node: the trie node that matches everything before position i
    private boolean dfs(String word, int i, TrieNode node) {
        // If we have matched every character of the pattern, the node must be the end of a word
        if (i == word.length()) {
            return node.isWord;
        }

        // The pattern character at position i
        char c = word.charAt(i);

        // A dot can stand for any letter, so try every child that exists
        if (c == '.') {
            // j is the letter index we are trying: 0 = 'a', ..., 25 = 'z'
            for (int j = 0; j < 26; j++) {
                // Only follow children that exist, and check whether the rest of the pattern matches below them
                if (node.children[j] != null && dfs(word, i + 1, node.children[j])) {
                    return true;   // one branch matched, so the whole search succeeds
                }
            }
            // No letter worked at this dot
            return false;
        }

        // A normal letter: convert it to an index, the same way addWord does
        int idx = c - 'a';

        // If the trie has no child for this letter, the pattern cannot match
        if (node.children[idx] == null) {
            return false;
        }

        // Otherwise move down to that child and match the rest of the pattern
        return dfs(word, i + 1, node.children[idx]);
    }
}
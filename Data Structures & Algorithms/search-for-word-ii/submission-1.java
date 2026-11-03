
class Solution {

    // One node in the trie: one letter position in some word
    private static class TrieNode {
        // children[0] is 'a', children[1] is 'b', ..., children[25] is 'z'
        // null means no word continues with that letter from this node
        TrieNode[] children = new TrieNode[26];

        // The complete word that ends at this node, or null if no word ends here.
        // Storing the word itself (not just a flag) lets us return it without rebuilding it.
        String word = null;
    }

    public List<String> findWords(char[][] board, String[] words) {
        // Step 1: put every target word into a trie
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode curr = root;   // walks down the trie as we insert w
            for (int i = 0; i < w.length(); i++) {
                int idx = w.charAt(i) - 'a';   // letter -> array index
                if (curr.children[idx] == null) {
                    curr.children[idx] = new TrieNode();
                }
                curr = curr.children[idx];
            }
            curr.word = w;   // mark the end of w and remember the full word
        }

        // Step 2: start a DFS from every cell of the board
        List<String> result = new ArrayList<String>();   // all words found so far
        for (int r = 0; r < board.length; r++) {         // r = row index
            for (int c = 0; c < board[0].length; c++) {  // c = column index
                dfs(board, r, c, root, result);
            }
        }
        return result;
    }

    // Explores the board from cell (r, c), following only paths that match the trie
    // board: the grid of letters
    // r, c: the cell we are standing on
    // parent: the trie node for the letters read before this cell
    // result: the list where found words are collected
    private void dfs(char[][] board, int r, int c, TrieNode parent, List<String> result) {
        char ch = board[r][c];          // the letter in this cell
        int idx = ch - 'a';             // its index in the children array

        // If no word in the trie continues with this letter, stop this path
        TrieNode node = parent.children[idx];
        if (node == null) {
            return;
        }

        // We reached the end of a target word. Record it.
        if (node.word != null) {
            result.add(node.word);
            // Clear it so the same word isn't added twice if another path finds it
            node.word = null;
        }

        // Mark this cell as used for the current path so we don't reuse it
        board[r][c] = '#';

        // The four neighbors: up, down, left, right
        int[] dr = {-1, 1, 0, 0};   // row changes
        int[] dc = {0, 0, -1, 1};   // column changes

        for (int k = 0; k < 4; k++) {
            int nr = r + dr[k];     // neighbor row
            int nc = c + dc[k];     // neighbor column

            // Only move to neighbors that are on the board and not already used
            if (nr >= 0 && nr < board.length && nc >= 0 && nc < board[0].length
                    && board[nr][nc] != '#') {
                dfs(board, nr, nc, node, result);
            }
        }

        // Backtrack: unmark the cell so other paths can use it
        board[r][c] = ch;
    }
}
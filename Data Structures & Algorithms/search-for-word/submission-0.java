class Solution {

    // Directions for the four neighbors: up, down, left, right
    private static final int[] DR = {-1, 1, 0, 0};   // row changes
    private static final int[] DC = {0, 0, -1, 1};   // column changes

    public boolean exist(char[][] board, String word) {
        // Try starting the word from every cell on the board
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (dfs(board, word, r, c, 0)) {
                    return true;   // found a valid path, stop early
                }
            }
        }
        return false;
    }

    // Can word[k..] be spelled starting from cell (r, c)?
    // board: the grid of letters
    // word: the target word
    // r, c: the cell we are standing on
    // k: the index in word we need to match at this cell
    private boolean dfs(char[][] board, String word, int r, int c, int k) {
        // Base case: every letter has been matched
        if (k == word.length()) {
            return true;
        }

        // Stay inside the board, and the cell must hold the letter we need
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length
                || board[r][c] != word.charAt(k)) {
            return false;
        }

        // Choose: mark this cell as used on the current path
        char saved = board[r][c];
        board[r][c] = '#';

        // Explore: try each neighbor for the next letter
        boolean found = false;
        for (int d = 0; d < 4 && !found; d++) {
            found = dfs(board, word, r + DR[d], c + DC[d], k + 1);
        }

        // Undo: restore the cell so other paths can use it
        board[r][c] = saved;

        return found;
    }
}
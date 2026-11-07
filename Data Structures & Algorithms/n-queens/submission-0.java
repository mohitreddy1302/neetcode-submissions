
class Solution {
    public List<List<String>> solveNQueens(int n) {
        // Every valid board is stored here as a list of row strings
        List<List<String>> result = new ArrayList<List<String>>();

        // board[i][j] is 'x' for an empty cell and 'Q' for a queen
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = 'x';
            }
        }

        // Place queens row by row, starting from row 0
        placeQueens(board, 0, result);
        return result;
    }

    // Tries to place one queen in this row, then recurses to the next row
    // board: the current board state
    // row: the row we are filling now
    // result: all finished boards
    private void placeQueens(char[][] board, int row, List<List<String>> result) {
        int n = board.length;

        // Base case: a queen is placed in every row, so convert the board and save it
        if (row == n) {
            result.add(buildBoard(board));
            return;
        }

        // Try every column in this row
        for (int col = 0; col < n; col++) {
            // Only place the queen if no queen above can attack this cell
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q';               // choose
                placeQueens(board, row + 1, result); // explore
                board[row][col] = 'x';               // undo
            }
        }
    }

    // Checks the column and the two upward diagonals. Rows below are still empty,
    // so only rows above the current row need to be checked.
    private boolean isSafe(char[][] board, int row, int col) {
        int n = board.length;

        // Same column, looking up
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // Upper-left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // Upper-right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    // Converts the board into a list of row strings like "..Q."
    private List<String> buildBoard(char[][] board) {
        List<String> rows = new ArrayList<String>();
        for (int i = 0; i < board.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < board.length; j++) {
                // The problem uses '.' for empty cells, so map 'x' to '.'
                sb.append(board[i][j] == 'Q' ? 'Q' : '.');
            }
            rows.add(sb.toString());
        }
        return rows;
    }
}
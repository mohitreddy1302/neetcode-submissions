class Solution {

    public boolean isValidSudoku(char[][] board) {

        // Visit every cell
        for (int row = 0; row < 9; row++) {

            for (int col = 0; col < 9; col++) {

                char value = board[row][col];

                // Empty cell - nothing to check
                if (value == '.') {
                    continue;
                }

                // -------------------------
                // 1. CHECK CURRENT ROW
                // -------------------------
                for (int j = 0; j < 9; j++) {

                    // Don't compare the cell with itself
                    if (j != col && board[row][j] == value) {
                        return false;
                    }
                }

                // -------------------------
                // 2. CHECK CURRENT COLUMN
                // -------------------------
                for (int i = 0; i < 9; i++) {

                    // Don't compare the cell with itself
                    if (i != row && board[i][col] == value) {
                        return false;
                    }
                }

                // -------------------------
                // 3. CHECK CURRENT 3x3 BOX
                // -------------------------

                // Find top-left corner of this cell's 3x3 box
                int startRow = (row / 3) * 3;
                int startCol = (col / 3) * 3;

                for (int r = startRow; r < startRow + 3; r++) {

                    for (int c = startCol; c < startCol + 3; c++) {

                        // Don't compare the cell with itself
                        if ((r != row || c != col)
                                && board[r][c] == value) {
                            return false;
                        }
                    }
                }
            }
        }

        // No duplicates found
        return true;
    }
}
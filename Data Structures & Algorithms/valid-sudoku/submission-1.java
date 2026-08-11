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
/*Time: O(n³)
Extra Space: O(1)*/
/*import java.util.*;

class Solution {
    public boolean isValidSudoku(char[][] board) {

        // 9 sets for rows, columns, and 3x3 boxes
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] boxes = new HashSet[9];

        // Initialize all sets
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        // Visit every cell once
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {

                char value = board[row][col];

                // Ignore empty cells
                if (value == '.') {
                    continue;
                }

                // Find which 3x3 box this cell belongs to
                int boxIndex = (row / 3) * 3 + (col / 3);

                // If already present in row, column, or box -> invalid
                if (rows[row].contains(value) ||
                    cols[col].contains(value) ||
                    boxes[boxIndex].contains(value)) {

                    return false;
                }

                // Otherwise remember this value
                rows[row].add(value);
                cols[col].add(value);
                boxes[boxIndex].add(value);
            }
        }

        return true;
    }*/
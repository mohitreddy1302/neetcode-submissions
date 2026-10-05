/*class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[0].length; column++) {
                if (matrix[row][column] == target) {
                    return true;
                }
            }
        }

        return false;
    }
}*/
class Solution {

    // Searches for the target in one specific row
    private boolean searchInRow(int[][] matrix, int target, int row) {

        int columns = matrix[0].length;

        // Binary search boundaries for the selected row
        int start = 0;
        int end = columns - 1;

        while (start <= end) {

            // Find the middle column
            int mid = start + (end - start) / 2;

            // Target found
            if (target == matrix[row][mid]) {
                return true;
            }

            // Target is greater, so search in the right half
            else if (target > matrix[row][mid]) {
                start = mid + 1;
            }

            // Target is smaller, so search in the left half
            else {
                end = mid - 1;
            }
        }

        // Target does not exist in this row
        return false;
    }

    public boolean searchMatrix(int[][] matrix, int target) {

        // Number of rows and columns
        int rows = matrix.length;
        int columns = matrix[0].length;

        // Binary search boundaries for rows
        int startRow = 0;
        int endRow = rows - 1;

        while (startRow <= endRow) {

            // Find the middle row
            int midRow = startRow
                    + (endRow - startRow) / 2;

            /*
             * Check whether the target can exist in this row.

             * The row is sorted, so:
             * - target must be greater than or equal to the first element
             * - target must be less than or equal to the last element
             */
            if (target >= matrix[midRow][0]
                    && target <= matrix[midRow][columns - 1]) {

                // The correct row is found.
                // Now perform binary search inside this row.
                return searchInRow(matrix, target, midRow);
            }

            /*
             * If target is greater than the last element
             * of the middle row, move to the rows below.
             */
            else if (target > matrix[midRow][columns - 1]) {
                startRow = midRow + 1;
            }

            /*
             * Otherwise, target is smaller than the first element
             * of the middle row, so search the rows above.
             */
            else {
                endRow = midRow - 1;
            }
        }

        // Target was not found in any row
        return false;
    }
}
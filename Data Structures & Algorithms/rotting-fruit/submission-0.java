
class Solution {
    public int orangesRotting(int[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;

        Queue<int[]> q = new ArrayDeque<>();
        int fresh = 0;

        // Step 1: put all rotten fruit in the queue, and count the fresh fruit
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] == 2) {
                    q.add(new int[]{r, c});
                } else if (grid[r][c] == 1) {
                    fresh++;
                }
            }
        }

        // No fresh fruit at all: zero minutes needed
        if (fresh == 0) return 0;

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int minutes = 0;

        // Step 2: each loop of the while is one minute
        while (!q.isEmpty() && fresh > 0) {
            int size = q.size();   // rotten fruit from the previous minute

            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                int r = cur[0];
                int c = cur[1];

                for (int[] d : dirs) {
                    int nr = r + d[0];
                    int nc = c + d[1];

                    // Only fresh fruit inside the grid can rot
                    if (nr >= 0 && nc >= 0 && nr < ROWS && nc < COLS && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;   // mark as rotten when added
                        fresh--;
                        q.add(new int[]{nr, nc});
                    }
                }
            }

            minutes++;
        }

        // If some fresh fruit is still left, it can never rot
        return fresh == 0 ? minutes : -1;
    }
}


class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;

        boolean[][] visit = new boolean[ROWS][COLS];
        Queue<int[]> q = new ArrayDeque<>();

        // Step 1: put every treasure chest in the queue at distance 0
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] == 0) {
                    q.add(new int[]{r, c});
                    visit[r][c] = true;
                }
            }
        }

        // The four directions: down, up, right, left
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        int dist = 0;

        // Step 2: expand one level at a time
        while (!q.isEmpty()) {
            int size = q.size();   // number of cells in the current level

            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                int r = cur[0];
                int c = cur[1];

                // Every cell in the queue is at distance 'dist'
                grid[r][c] = dist;

                for (int[] d : dirs) {
                    int nr = r + d[0];
                    int nc = c + d[1];

                    // Skip cells outside the grid
                    if (nr < 0 || nc < 0 || nr >= ROWS || nc >= COLS) continue;

                    // Skip cells already visited, and water (-1)
                    if (visit[nr][nc] || grid[nr][nc] == -1) continue;

                    visit[nr][nc] = true;
                    q.add(new int[]{nr, nc});
                }
            }

            dist++;   // the next level is one step further
        }
    }
}
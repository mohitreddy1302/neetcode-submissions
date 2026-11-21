

class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int ROWS = heights.length;
        int COLS = heights[0].length;

        boolean[][] pacific = new boolean[ROWS][COLS];
        boolean[][] atlantic = new boolean[ROWS][COLS];

        Queue<int[]> pacificQueue = new ArrayDeque<>();
        Queue<int[]> atlanticQueue = new ArrayDeque<>();

        // Top row and bottom row
        for (int c = 0; c < COLS; c++) {
            if (!pacific[0][c]) {
                pacific[0][c] = true;
                pacificQueue.add(new int[]{0, c});
            }
            if (!atlantic[ROWS - 1][c]) {
                atlantic[ROWS - 1][c] = true;
                atlanticQueue.add(new int[]{ROWS - 1, c});
            }
        }

        // Left column and right column
        for (int r = 0; r < ROWS; r++) {
            if (!pacific[r][0]) {
                pacific[r][0] = true;
                pacificQueue.add(new int[]{r, 0});
            }
            if (!atlantic[r][COLS - 1]) {
                atlantic[r][COLS - 1] = true;
                atlanticQueue.add(new int[]{r, COLS - 1});
            }
        }

        bfs(heights, pacific, pacificQueue);
        bfs(heights, atlantic, atlanticQueue);

        List<List<Integer>> result = new ArrayList<>();
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (pacific[r][c] && atlantic[r][c]) {
                    result.add(new ArrayList<>(Arrays.asList(r, c)));
                }
            }
        }
        return result;
    }

    private void bfs(int[][] heights, boolean[][] visit, Queue<int[]> q) {
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];

            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];

                // Skip outside cells, visited cells, and cells lower than the current one
                if (nr < 0 || nc < 0 || nr >= heights.length || nc >= heights[0].length) continue;
                if (visit[nr][nc] || heights[nr][nc] < heights[r][c]) continue;

                visit[nr][nc] = true;
                q.add(new int[]{nr, nc});
            }
        }
    }
}
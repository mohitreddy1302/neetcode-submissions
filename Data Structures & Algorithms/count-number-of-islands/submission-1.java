
class Solution {
    public int numIslands(char[][] grid) {
        int islands = 0;
        int n = grid.length;
        int m = grid[0].length;

        // vis[i][j] is true once cell (i, j) has been part of a counted island
        boolean[][] vis = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // An unvisited land cell starts a new island
                if (grid[i][j] == '1' && !vis[i][j]) {
                    dfs(i, j, vis, grid, n, m);
                    islands++;
                }
            }
        }

        return islands;
    }

    // Marks every land cell connected to (i, j) as visited
    private void dfs(int i, int j, boolean[][] vis, char[][] grid, int n, int m) {
        // Stop at the edge of the grid, at water, or at a cell already visited
        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] == '0' || vis[i][j]) {
            return;
        }

        vis[i][j] = true;

        // Explore the four directions: up, down, left, right
        dfs(i - 1, j, vis, grid, n, m);
        dfs(i + 1, j, vis, grid, n, m);
        dfs(i, j - 1, vis, grid, n, m);
        dfs(i, j + 1, vis, grid, n, m);
    }
}
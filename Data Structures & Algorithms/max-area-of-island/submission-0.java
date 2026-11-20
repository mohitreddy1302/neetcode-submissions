class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int best = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    best = Math.max(best, dfs(grid, i, j));
                }
            }
        }

        return best;
    }

    private int dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }

        grid[i][j] = 0;   // mark the cell as visited by sinking it
        int count = 1;    // count the current cell

        count += dfs(grid, i - 1, j);   // land above
        count += dfs(grid, i + 1, j);   // land below
        count += dfs(grid, i, j - 1);   // land to the left
        count += dfs(grid, i, j + 1);   // land to the right

        return count;
    }
}
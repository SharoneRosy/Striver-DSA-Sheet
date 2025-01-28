class Solution {
    
    private int dfs(int[][] grid, int i, int j, int m, int n) {
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] <= 0) {
            return 0;
        }
        
        // Collect fish at current cell
        int cnt = grid[i][j];
        // Mark this cell as visited by setting it to -1
        grid[i][j] = -1;

        // Directions arrays for row and column movements
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        // Explore all 4 possible directions
        for (int k = 0; k < 4; k++) {
            int nrow = i + dr[k];
            int ncol = j + dc[k];
            cnt += dfs(grid, nrow, ncol, m, n);
        }

        return cnt;
    }

    public int findMaxFish(int[][] grid) {
        int max = 0;
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Only start a new DFS if the cell has fish and has not been visited
                if (grid[i][j] > 0) {
                    int cnt = dfs(grid, i, j, m, n);
                    max = Math.max(max, cnt); // Update the maximum fish found
                }
            }
        }
        return max;
    }
}

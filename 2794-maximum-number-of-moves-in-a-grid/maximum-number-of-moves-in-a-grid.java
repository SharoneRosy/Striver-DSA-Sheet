class Solution {
    private int solve(int i, int j, int[][] grid, int[][] dp) {
        if (j == grid[0].length - 1) return 0;
        if (dp[i][j] != -1) return dp[i][j];

        int maxMoves = 0;
        for (int row = -1; row <= 1; row++) {
            int newI = i + row;
            if (newI >= 0 && newI < grid.length && grid[newI][j + 1] > grid[i][j]) {
                maxMoves = Math.max(maxMoves, 1 + solve(newI, j + 1, grid, dp));
            }
        }

        return dp[i][j] = maxMoves;
    }

    public int maxMoves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int[] row : dp) Arrays.fill(row, -1);

        int maxMoves = 0;
        for (int i = 0; i < m; i++) {
            maxMoves = Math.max(maxMoves, solve(i, 0, grid, dp));
        }

        return maxMoves;
    }
}
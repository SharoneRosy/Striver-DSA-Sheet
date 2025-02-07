class Solution {
    public double knightProbability(int n, int k, int row, int column) {
        double[][][] dp = new double[k + 1][n][n];
        return dfs(n, k, row, column, dp);
    }

    private double dfs(int n, int k, int r, int c, double[][][] dp) {
        if (r < 0 || c < 0 || r >= n || c >= n) return 0.0;
        if (k == 0) return 1.0; // If no moves left, still on board => probability = 1

        if (dp[k][r][c] != 0) return dp[k][r][c]; // Memoized result

        double prob = 0.0;
        
        // Iteratively generate knight moves instead of using a predefined array
        for (int dr = -2; dr <= 2; dr++) {
            for (int dc = -2; dc <= 2; dc++) {
                if (Math.abs(dr) + Math.abs(dc) == 3) { // Ensures valid knight move
                    prob += dfs(n, k - 1, r + dr, c + dc, dp) / 8.0;
                }
            }
        }

        return dp[k][r][c] = prob;
    }
}

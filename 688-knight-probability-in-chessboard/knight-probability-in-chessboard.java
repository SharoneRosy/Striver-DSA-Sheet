class Solution {
    public double knightProbability(int n, int k, int row, int column) {
        double[][][] dp = new double[k + 1][n][n];
        dp[0][row][column] = 1.0; // Base case: Knight starts at (row, column)

        for (int step = 1; step <= k; step++) {
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    for (int dr = -2; dr <= 2; dr++) {
                        for (int dc = -2; dc <= 2; dc++) {
                            if (Math.abs(dr) + Math.abs(dc) == 3) { // Valid knight move
                                int nr = r + dr, nc = c + dc;
                                if (nr >= 0 && nc >= 0 && nr < n && nc < n) {
                                    dp[step][nr][nc] += dp[step - 1][r][c] / 8.0; // Transition
                                }
                            }
                        }
                    }
                }
            }
        }

        double result = 0.0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                result += dp[k][r][c]; // Sum up all probabilities after k moves
            }
        }
        return result;
    }
}

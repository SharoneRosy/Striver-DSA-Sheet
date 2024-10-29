class Solution {
    public int maxMoves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        
        // Fill dp with -1 to mark unvisited cells
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        
        // First column cells can make 0 moves initially
        for(int i = 0; i < m; i++) {
            dp[i][0] = 0;
        }
        
        int maxMoves = 0;
        
        // Process column by column
        for(int j = 0; j < n-1; j++) {
            for(int i = 0; i < m; i++) {
                if(dp[i][j] != -1) {  // If this cell is reachable
                    // Try all three possible moves
                    for(int k = -1; k <= 1; k++) {
                        int newRow = i + k;
                        if(newRow >= 0 && newRow < m && grid[newRow][j+1] > grid[i][j]) {
                            dp[newRow][j+1] = Math.max(dp[newRow][j+1], dp[i][j] + 1);
                            maxMoves = Math.max(maxMoves, dp[newRow][j+1]);
                        }
                    }
                }
            }
        }
        
        return maxMoves;
    }
}
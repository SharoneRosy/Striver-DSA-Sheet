class Solution {
   public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
           int n = obstacleGrid.length;
           int m = obstacleGrid[0].length;
           int[][] dp = new int[n][m];
           for(int row = 0; row < n; row++){
               for(int col = 0; col < m; col++){
                   if(obstacleGrid[row][col] == 1) dp[row][col] = 0;
                   else if(row == 0 && col == 0) dp[row][col] = 1;
                   else{
                       int up = 0, left = 0;
                       if(row > 0) up = dp[row - 1][col];
                       if(col > 0) left = dp[row][col - 1];
                       dp[row][col] = up + left;
                   }
               }
           }
           return dp[n - 1][m - 1];
   }
}
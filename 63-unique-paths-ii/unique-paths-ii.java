class Solution {
     public static int totalPaths(int row, int col, int[][] obstacleGrid, int[][] dp){
           if(row < 0 || col < 0 || obstacleGrid[row][col] == 1) return 0;
           if(row == 0 && col == 0) return 1;
           if(dp[row][col] != -1) return dp[row][col];
   
           int up = totalPaths(row - 1, col, obstacleGrid, dp);
           int left = totalPaths(row, col - 1, obstacleGrid, dp);
           return dp[row][col] = up + left;
       }
       public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
           int n = obstacleGrid.length;
           int m = obstacleGrid[0].length;
           int[][] dp = new int[n][m];
           for(int[] it : dp) Arrays.fill(it, -1);
           return totalPaths(n - 1, m - 1, obstacleGrid, dp);
       }
}
class Solution {
   
     public static int helper(int[][] grid, int row, int col,int [][]dp){
           if(row == 0 && col == 0) return grid[row][col];
           if(row < 0 || col < 0) return Integer.MAX_VALUE;
           if(dp[row][col]!=-1) return dp[row][col];
           int up = helper(grid, row - 1, col,dp);
           int left = helper(grid, row, col - 1,dp);
   
           return dp[row][col]=grid[row][col] + Math.min(up, left);
       }
       public static int minPathSum(int[][] grid) {
           int n = grid.length;
           int m = grid[0].length;
           int dp[][]=new int[n][m];
           for(int[] it:dp){
            Arrays.fill(it,-1);
           }
           return helper(grid, n - 1, m - 1,dp);
       }
}
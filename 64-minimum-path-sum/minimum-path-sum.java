class Solution {
    public int f(int r,int c,int [][] grid,int [][]dp){
        if(r<0 || c<0 ) return (int)(1e9);
        if(r==0 && c==0) return grid[r][c];
        if(dp[r][c]!=-1) return dp[r][c];
        int up=f(r-1,c,grid,dp);
        int left=f(r,c-1,grid,dp);
        return dp[r][c]=grid[r][c]+Math.min(up,left);
    }
    public int minPathSum(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int dp[][]=new int[n][m];
        for(int[] it:dp) Arrays.fill(it,-1);
        return f(n-1,m-1,grid,dp);
    }
}
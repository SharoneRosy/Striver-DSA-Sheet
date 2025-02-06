class Solution {
    public int solve(int i,int j,int [][] grid,int [][]dp){
        if(i<0 || j<0) return (int)(1e9);
        if(i==0 && j==0) return grid[i][j];
        if(dp[i][j]!=-1) return dp[i][j];
        int up=solve(i-1,j,grid,dp);
        int left=solve(i,j-1,grid,dp);
        return dp[i][j]=grid[i][j]+Math.min(left,up);
    }
    public int minPathSum(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int dp[][]=new int[n][m];
        for(int [] row:dp) Arrays.fill(row,-1);
        // return solve(n-1,m-1,grid,dp);

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 && j==0) dp[i][j]=grid[0][0];
                else{
                    int up=(int)(1e9);
                    int left=(int)(1e9);
                    if(i>0) up=dp[i-1][j];
                    if(j>0) left=dp[i][j-1];
                    dp[i][j]=grid[i][j]+Math.min(up,left);
                }
            }
        }
        return dp[n-1][m-1];
    }
}
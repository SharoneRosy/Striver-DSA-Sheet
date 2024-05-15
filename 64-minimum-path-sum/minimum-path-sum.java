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
        for(int[] it:dp) Arrays.fill(it,0);
     
        for(int r=0;r<n;r++){
            for(int c=0;c<m;c++){
                if(r==0 && c==0) dp[r][c]=grid[0][0];
                else{
                            int up=(int)(1e9);
                            int left=(int)(1e9);
                            if(r>0) up=dp[r-1][c];
                            if(c>0) left=dp[r][c-1];
                            dp[r][c]=grid[r][c] + Math.min(up,left);
                }
               
            }
        }
        return dp[n-1][m-1];
    }
    
}
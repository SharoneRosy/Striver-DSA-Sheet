import java.util.Arrays;

class Solution {
    public int f(int i,int j,int [][]dp){
        if(i==0 && j==0) return 1;
        if(i<0 || j<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int up=f(i-1,j,dp);
        int left=f(i,j-1,dp);
        return dp[i][j]=up+left;
    }
    public int uniquePaths(int m, int n) {
        int dp[][]=new int[m+1][n+1];
        for(int [] it:dp) {
            Arrays.fill(it,-1);
        }
        return f(m-1,n-1,dp);
    }
}
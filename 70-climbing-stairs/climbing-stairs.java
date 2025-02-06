class Solution {
    public int solve(int i,int n,int []dp){
        if(i>n) return 0;
        if(i==n ) return 1;
        if(dp[i]>0) return dp[i];
        dp[i]=solve(i+1,n,dp)+solve(i+2,n,dp);
        return dp[i];
    }
    public int climbStairs(int n) {
        int dp[]=new int[n+1];
        return solve(0,n,dp);
    }
}
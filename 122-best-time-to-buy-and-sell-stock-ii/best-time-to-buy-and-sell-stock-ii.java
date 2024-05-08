class Solution {
    public int f(int i,int buy,int[] p,int [][]dp){
        if(i==p.length) return 0;
        if(dp[i][buy]!=-1) return dp[i][buy];
        if(buy==1){
            return dp[i][buy]= Math.max(-p[i]+f(i+1,0,p,dp),f(i+1,1,p,dp));
        }else {
            return dp[i][buy]=Math.max( p[i]+f(i+1,1,p,dp),f(i+1,0,p,dp));
        }
    }
    public int maxProfit(int[] p) {
        int n=p.length;
        int dp[][]=new int[n+1][2];
        for(int[] it:dp) Arrays.fill(it,0);
        dp[n][0]=dp[n][1]=0;
        for(int i=n-1;i>=0;i--){
            for(int buy=0;buy<=1;buy++){
                 if(buy==1){
                    dp[i][buy]= Math.max(-p[i]+dp[i+1][0],dp[i+1][1]);
                }else {
                    dp[i][buy]=Math.max( p[i]+dp[i+1][1],dp[i+1][0]);
                }
                    }
        }
        return dp[0][1];
    }
}
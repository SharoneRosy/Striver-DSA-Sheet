class Solution {
      public int f(int i,int buy,int[] p,int [][]dp,int fee){
        if(i==p.length) return 0;
        if(dp[i][buy]!=-1) return dp[i][buy];
        if(buy==1){
            return dp[i][buy]= Math.max(-p[i]+f(i+1,0,p,dp,fee),f(i+1,1,p,dp,fee));
        }else {
            return dp[i][buy]=Math.max( p[i]-fee+f(i+1,1,p,dp,fee),f(i+1,0,p,dp,fee));
        }
    }
    public int maxProfit(int[] p,int fee) {
        int n=p.length;
        int dp[][]=new int[n][2];
        for(int[] it:dp) Arrays.fill(it,-1);
        return f(0,1,p,dp,fee);
    }
}
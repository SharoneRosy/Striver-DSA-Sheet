class Solution {
     public int f(int i,int buy,int cap,int[] p,int [][][]dp){
        if(i==p.length || cap==0) return 0;
        if(dp[i][buy][cap]!=-1) return dp[i][buy][cap];
        if(buy==1){
            return dp[i][buy][cap]= Math.max(-p[i]+f(i+1,0,cap,p,dp),f(i+1,1,cap,p,dp));
        }else {
            return dp[i][buy][cap]=Math.max( p[i]+f(i+1,1,cap-1,p,dp),f(i+1,0,cap,p,dp));
        }
    }
    public int maxProfit(int[] p) {
        int n=p.length;
        int cap=2;
        int dp[][][]=new int[n][2][3];
        for(int[][] it:dp) for(int []it1:it) Arrays.fill(it1,-1);
        return f(0,1,2,p,dp);
    }
}
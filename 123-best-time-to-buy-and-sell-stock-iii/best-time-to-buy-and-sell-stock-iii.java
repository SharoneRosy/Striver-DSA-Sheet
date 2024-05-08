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
        int after[][]=new int[2][3];
        int curr[][]=new int[2][3];
        for(int i=n-1;i>=0;i--){
            for(int buy=0;buy<=1;buy++){
                
                for(int cap=1;cap<=2;cap++){
                if(buy==1){
                    curr[1][cap]= Math.max(-p[i]+after[0][cap],after[1][cap]);
                }else {
                    curr[0][cap]=Math.max( p[i]+after[1][cap-1],after[0][cap]);
                }
                }  
            }
            after=curr.clone();
        }
        return after[1][2];
    }
}
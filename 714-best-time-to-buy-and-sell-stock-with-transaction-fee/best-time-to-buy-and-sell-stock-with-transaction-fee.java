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
        int []ahead=new int[2];
        int []cur=new int[2];
        ahead[0]=ahead[1]=0;
        for(int i=n-1;i>=0;i--){
            for(int buy=0;buy<=1;buy++){
                 if(buy==1){
                   cur[buy]= Math.max(-p[i]+ahead[0],ahead[1]);
                }else {
                    cur[buy]=Math.max( p[i]-fee+ahead[1],ahead[0]);
                }
                    }
            ahead=cur.clone();   
        }
        return ahead[1];
    }
}
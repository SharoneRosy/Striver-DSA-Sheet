class Solution {
    //Recursion
    // public int solve(int amount, int[] coins,int i){
    //     if (amount==0) return 1;
    //     if(i==0){
    //         if(amount%coins[0]==0) return 1;
    //         else return 0;
    //     }
    //     int notpick=solve(amount,coins,i-1);
    //     int pick=0;
    //     if(amount>=coins[i]){
    //         pick=solve(amount-coins[i],coins,i);
    //     }
    //     return pick+notpick;
    // }
    //memoization
    // public int solve(int amount, int[] coins,int i,int dp[][]){
    //     if (amount==0) return 1;
    //     if(i==0){
    //         if(amount%coins[0]==0) return 1;
    //         else return 0;
    //     }
    //     if(dp[i][amount]!=-1) return dp[i][amount];
    //     int notpick=solve(amount,coins,i-1,dp);
    //     int pick=0;
    //     if(amount>=coins[i]){
    //         pick=solve(amount-coins[i],coins,i,dp);
    //     }
    //     dp[i][amount]=pick+notpick;
    //     return dp[i][amount];
    // }


    // public int change(int amount, int[] coins) {
    //     int n=coins.length;
    //     int dp[][]=new int [coins.length][amount+1];
    //     for(int[]  row:dp){
    //         Arrays.fill(row,-1);
    //     }
    //     return solve(amount,coins,n-1,dp);
    // }

    public int change(int amount, int[] coins) {
        int n=coins.length;
        int dp[][]=new int [coins.length][amount+1];

        for(int i=0;i<coins.length;i++){
            dp[i][0]=1;
        }
        for(int j=0;j<=amount;j++){
            if(j%coins[0]==0) dp[0][j]=1;
            else dp[0][j]=0;
        }
        for(int i=1;i<n;i++){
            for(int amt=1;amt<=amount;amt++){
                 int notpick=dp[i-1][amt];
                 int pick=0;
                 if(amt>=coins[i]){
                       pick=dp[i][amt-coins[i]];
               }
              dp[i][amt]=pick+notpick;
             }
        }
        return dp[n-1][amount];
    }
}
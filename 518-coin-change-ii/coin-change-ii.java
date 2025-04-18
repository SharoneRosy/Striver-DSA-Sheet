class Solution {
    public int solve(int amount,int []coins,int i){
        if(amount==0) return 1;
        if(i==0) {
            if(amount%coins[0]==0) return 1;
            else return 0;
        }

        int notpick=solve(amount,coins,i-1);
        int pick=0;
        if(amount>=coins[i]){
            pick=solve(amount-coins[i],coins,i);
        }
        return pick+notpick;
    }
    // public int change(int amount, int[] coins) {
    //     int n=coins.length;
    //     // return solve(amount,coins,n-1);
    // }
    // public int change(int amount,int [] coins){
    //     int n=coins.length;
    //     int dp[][]=new int[coins.length][amount+1];

    //     for(int i=0;i<coins.length;i++){
    //         dp[i][0]=1;
    //     }
    //     for(int j=0;j<=amount;j++){
    //         if(j%coins[0]==0) dp[0][j]=1;
    //         else dp[0][j]=0;
    //     }
    //     for(int i=1;i<n;i++){
    //         for(int amt=1;amt<=amount;amt++){
    //             int notpick=dp[i-1][amt];
    //              int pick=0;
    //              if(amt>=coins[i]){
    //                    pick=dp[i][amt-coins[i]];
    //            }
    //         dp[i][amt]=pick+notpick;
    //         }
    //     }
    //     return dp[n-1][amount];
    // }
     public int change(int amount,int [] coins){
        int n=coins.length;
        int []prev=new int[amount+1];

        for(int j=0;j<=amount;j++){
            if(j%coins[0]==0)   prev[j]=1;
            else prev[j]=0;
        }
        for(int i=1;i<n;i++){
            int []curr=new int[amount+1];
            for(int amt=0;amt<=amount;amt++){
                int notpick=prev[amt];
                 int pick=0;
                 if(amt>=coins[i]){
                       pick=curr[amt-coins[i]];
               }
               curr[amt]=pick+notpick;
            }
            prev=curr;
        }
        return prev[amount];
    }

}


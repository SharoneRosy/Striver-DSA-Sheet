class Solution {
    public int f(int i,int prev,int []nums,int n,int [][]dp){
        if(i==n) return 0;
        if(dp[i][prev+1]!=-1) return dp[i][prev+1];
        int len=0+f(i+1,prev,nums,n,dp);
        if(prev==-1 || nums[i]>nums[prev]){
            len=Math.max(len,1+f(i+1,i,nums,n,dp));
        }
        return dp[i][prev+1]=len;
    }
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int dp[][]=new int[n+1][n+1];
        for(int[] it:dp) Arrays.fill(it,0);
        for(int i=n-1;i>=0;i--){
            for(int prev=i-1;prev>=-1;prev--){
                int len=0+dp[i+1][prev+1];
                if(prev==-1 || nums[i]>nums[prev]){
                    len=Math.max(len,1+dp[i+1][i+1]);
                }
                dp[i][prev+1]=len;
                    }
        }
        return dp[0][1-1];
    }
}
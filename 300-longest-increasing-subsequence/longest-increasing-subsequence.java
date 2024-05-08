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
        int dp[]=new int[n+1];
        Arrays.fill(dp,1);
        int maxi=1;
        for(int i=0;i<n;i++){
            for(int prev=0;prev<i;prev++){
                if(nums[i]>nums[prev]){
                    dp[i]=Math.max(dp[i],1+dp[prev]);
                }
            }
            maxi=Math.max(maxi,dp[i]);
        }
        return maxi;
    }
}
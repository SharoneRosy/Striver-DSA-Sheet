class Solution {
    int totalSum=0;
    private int solve(int[] nums,int i,int sum,int target,int [][] dp){
        if(i==nums.length){
            if(sum==target){
                return 1;
            }else{
                return 0;
            }
        }
        if(dp[i][sum+totalSum]!=Integer.MIN_VALUE) return dp[i][sum+totalSum];
    
           int add= solve(nums,i+1,sum+nums[i],target,dp);
           int sub= solve(nums,i+1,sum-nums[i],target,dp);
        
        dp[i][sum+totalSum]=add+sub;
        return dp[i][sum+totalSum];
    }
    public int findTargetSumWays(int[] nums, int target) {
        int n=nums.length;
        totalSum=Arrays.stream(nums).sum();
        int [][] dp=new int[nums.length][2*totalSum+1];
        for(int [] row:dp) Arrays.fill(row,Integer.MIN_VALUE);
         return solve(nums,0,0,target,dp);
        
    }
}
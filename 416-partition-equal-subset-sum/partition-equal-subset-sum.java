// class Solution {
//     public boolean f(int idx,int[] nums,boolean dp[][],int target){
//         if(target==0) return true;
//         if(idx<0 || target<0 ) return false;
//         if(dp[idx][target]!=false) return dp[idx][target];
//         boolean take=f(idx-1,nums,dp,target-nums[idx]);
//         boolean  nottake=f(idx-1,nums,dp,target);
//         return dp[idx][target]=take || nottake;

//     }
//     public boolean canPartition(int[] nums) {
//         int tsum=0;
//         int n=nums.length;
        
//         for(int i=0;i<nums.length;i++){
//             tsum+=nums[i];
//         }
//         if(tsum%2!=0) return false;
//         boolean dp[][]=new boolean [n+1][tsum/2+1];
//         return f(n-1,nums,dp,tsum/2);
//     }
// }

public class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // If sum is odd, it cannot be divided into two equal subsets
        if (sum % 2 != 0) {
            return false;
        }
        
        int target = sum / 2;
        boolean[][] dp = new boolean[n + 1][target + 1];
        
        // Base case: It is always possible to make a sum of 0 (by taking no elements)
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }
        
        for (int i = 1; i <= n; i++) {
            for (int t = 1; t <= target; t++) {
                // Exclude the current number
                dp[i][t] = dp[i - 1][t];
                
                // Include the current number if possible
                if (t >= nums[i - 1]) {
                    dp[i][t] = dp[i][t] || dp[i - 1][t - nums[i - 1]];
                }
            }
        }
        
        return dp[n][target];
    }
}

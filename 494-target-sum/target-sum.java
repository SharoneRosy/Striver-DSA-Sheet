class Solution {
    int res=0;
    private void solve(int[] nums,int i,int sum,int target){
        if(i==nums.length){
            if(sum==target){
                res++;
            }
        }else{
            solve(nums,i+1,sum+nums[i],target);
            solve(nums,i+1,sum-nums[i],target);
        }
    }
    public int findTargetSumWays(int[] nums, int target) {
        int n=nums.length;
        solve(nums,0,0,target);
        return res;
    }
}
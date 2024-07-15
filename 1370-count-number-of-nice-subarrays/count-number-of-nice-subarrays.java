class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return solve(nums , k ) - solve(nums, k-1);
    }
    
    public int solve(int[] nums, int k ){
        

        int n=nums.length,left=0,right=0;
        int noOfOdd=0,noOfnice=0;
        while(right<n){
            noOfOdd+=nums[right]%2;
            while(noOfOdd>k){
                noOfOdd-=nums[left]%2;
                left++;
            }
            noOfnice+=right-left+1;
            right++;
        }
        return noOfnice;
    }
    
}
class Solution {
    public int longestOnes(int[] nums, int k) {
        int left=0;
        int right=0;
        int n=nums.length;
        int zeros=0;
        int maxlen=0;
        while(right<n){
            if(nums[right]==0) zeros++;
            if(zeros>k){
                if(nums[left]==0) zeros--;
                left++;
            }
            if(zeros<=k){
                maxlen=Math.max(maxlen,right-left+1);
            }
            right++;
        }
        return maxlen;
    }
}
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int res=0;
        int maxi=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]==1){
                res++;
            }else{
                res=0;
            }
            maxi=Math.max(res,maxi);
        }return maxi;
    }
}
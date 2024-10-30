class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int lis[]=new int[n];
        Arrays.fill(lis,1);
        int max=1;
        for(int i=0;i<n;i++){
            for(int j=i-1;j>=0;j--){
                if(nums[j]<nums[i]){
                    lis[i]=Math.max(lis[i],lis[j]+1);
                    max=Math.max(max,lis[i]);
                }
            }
        }
        return max;
    }
}
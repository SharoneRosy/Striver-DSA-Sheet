class Solution {
    public int minimumDifference(int[] nums, int k) {
        if(k==1) return 0;
        Arrays.sort(nums);
        int l=0,r=k-1;
        int n=nums.length;
        int min=Integer.MAX_VALUE;
        while(r<n){
            min=Math.min(min,nums[r++]-nums[l++]);
        }
        return min;
    }
}
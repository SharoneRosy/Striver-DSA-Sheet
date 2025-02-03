class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int i=1,d=1;
        int max=1;
        for(int j=0;j<nums.length-1;j++){
            if(nums[j]<nums[j+1]) {
                i++;
                d=1;
            }else if(nums[j]>nums[j+1]){
                d++;
                i=1;
            }else{
                i=1;
                d=1;
            }
            max=Math.max(max,Math.max(i,d));
        }
        return max;
    }
}
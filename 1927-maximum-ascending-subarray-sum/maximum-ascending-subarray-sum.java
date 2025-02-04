class Solution {
    public int maxAscendingSum(int[] nums) {
        int n = nums.length;
        int sum = nums[0], maximum = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > nums[i - 1])
                sum += nums[i];
            else
                sum = nums[i];
            maximum = Math.max(sum, maximum);
        } 
        return maximum;         
    }
}
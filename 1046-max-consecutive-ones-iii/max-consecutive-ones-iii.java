class Solution {
    public int longestOnes(int[] nums, int k) {
        int first=0,second=0;
        while(second<nums.length){
            if(nums[second]==0) k--;
            if(k<0){
                if(nums[first]==0){
                    k++;
                }
                first++;
            }
            second++;
        }
        return second-first;

        
    }
}
class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        if (nums.length == 1) return nums[0] > k ? 1 : -1;
        int right = 0;
        int left = 0;
        int tmpOr = nums[left];
        if (tmpOr >= k) return 1;
        int ans = nums.length +1;

        while(right < nums.length ){
            if(tmpOr >= k ){
                ans = Math.min(ans, right - left + 1);
                left += 1;
                while(left < nums.length-1){
                    if(nums[left] == nums[left+1]){
                        left += 1;
                    }else{
                        break;
                    }
                }
                right = left ;
                tmpOr = nums[left];
            }else{
                right += 1;
                if(right < nums.length){
                    tmpOr = tmpOr | nums[right];
                    if(nums[right] >= k) return 1;
                }
            }
        }
        return ans == (nums.length +1) ? -1 : ans;
    }
    
}
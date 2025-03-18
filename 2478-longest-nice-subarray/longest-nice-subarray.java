class Solution {
        // sliding window -> O(N) TC, O(1) SC
    public int longestNiceSubarray(int[] nums) {
        int left = 0, right = 1, n = nums.length, res = 1;
        while(right < n){
            int idx = left;
            // use nums[right] to do AND operation with previous numbers 
            // within range[left, right-1]
            while(idx < right){
                if((nums[idx] & nums[right]) == 0) idx++;
                else 
                    break;
            }
            // current range is a nice subarray, update max length, move right pointer
            if(idx == right){
                // update max length
                res = Math.max(res, right - left + 1);
                right++;
            } else{ 
                // nums[idx] AND nums[right] != 0
                // move left pointer
                left = idx + 1;
                if(left == right) right++;
            }
        }
        return res;
    }
}
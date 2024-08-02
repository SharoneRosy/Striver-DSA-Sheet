class Solution {
    public int minSwaps(int[] nums) {
        int one = 0;
        for (int num : nums) {
            one += num;
        }

        int res = nums.length;
        for (int i = 0, j = 0, cnt = 0; i < nums.length; i++) {
            while (j - i < one) {
                cnt += nums[j % nums.length];
                j++;
            }

            res = Math.min(res, one - cnt);
            cnt -= nums[i];
        }
        return res;
    }
}
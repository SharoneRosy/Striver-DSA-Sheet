class Solution {
    public void sortColors(int[] nums) {
        int j = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == 2) {
                nums[i] = nums[j];
                nums[j] = 2;
                j--;
            }
        }
        // Start from j here as we don't want to swap with 2's that are already in their correct place
        for (int i = j; i >= 0; i--) {
            if (nums[i] == 1) {
                nums[i] = nums[j];
                nums[j] = 1;
                j--;
            }
        }
    }
}
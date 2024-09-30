class NumArray {
    private int[] prefixsum;

public NumArray(int[] nums) {
    prefixsum=new int[nums.length+1];
    for(int i=0;i<nums.length;i++){
        prefixsum[i+1]=prefixsum[i]+nums[i];
    }
}

public int sumRange(int i, int j) {
   return prefixsum[j+1]-prefixsum[i];
}
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
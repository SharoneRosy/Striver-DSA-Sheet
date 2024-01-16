class Solution {
    public int missingNumber(int[] nums) {
        int s=0;
        int n=nums.length;
        
        for(int i=0;i<n;i++){
            s+=nums[i];
        }
        int total=((n+1)*n)/2;
        return total-s;
    }
}
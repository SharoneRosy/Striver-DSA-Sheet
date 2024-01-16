class Solution {
    public boolean check(int[] nums) {
        int n=nums.length;
        int c=0;
        int ind=-1;
        for(int i=1;i<n;i++){
            if(nums[i-1]>nums[i]){
                ind=i;
                break;
            }
        }
        if (ind == -1) 
            return true;
        for(int i=ind+1;i<ind+n;i++){
            if(nums[(i-1)%n]>nums[(i)%n])
                return false;
        }
        return true;
    }
}
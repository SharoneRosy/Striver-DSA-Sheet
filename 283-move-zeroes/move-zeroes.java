class Solution {
    public void moveZeroes(int[] nums) {
        int cnt=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]!=0){
                int temp=nums[i];
                nums[i]=nums[cnt];
                nums[cnt]=temp;
                cnt++;
            }
        }
        
    }
}
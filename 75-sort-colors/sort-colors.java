class Solution {
    public void sortColors(int[] nums) {
        int low=0,mid=0;
        int n=nums.length;
        int high=n-1;
        while(mid<=high){
            if(nums[mid]==0){
                int temp=nums[mid];
                nums[mid]=nums[low];
                nums[low]=temp;
                low++;
                mid++;
            }else if(nums[mid]==1){
                mid++;
            }else{
                int temp=nums[high];
                nums[high]=nums[mid];
                nums[mid]=temp;
                high--;
                
            }
        }
        
    }
}
class Solution {
    public static void reverse(int[] arr, int low, int high){
        int i=low,j=high;
        while(i<j){
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }
    }
    public void nextPermutation(int[] nums) {
        int breakPoint=-1;
        int n=nums.length;
        for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                 breakPoint=i;
                break;
            }
        }

        if(breakPoint==-1){
            reverse(nums,0,n-1);
            return;
        } 

        for(int i=n-1;i>breakPoint;i--){
            if(nums[i]>nums[breakPoint]){
                int temp=nums[i];
                nums[i]=nums[breakPoint];
                nums[breakPoint]=temp;
                break;
            }
        }
        reverse(nums,breakPoint+1,n-1);
        return ;
        
    }
}
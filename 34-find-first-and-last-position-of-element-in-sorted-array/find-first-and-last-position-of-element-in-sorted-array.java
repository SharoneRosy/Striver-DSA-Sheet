class Solution {
    public int first(int[] nums,int target){
        int n=nums.length;
        int low=0;
        int high=n-1;
        int ans=-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(nums[mid]==target){
                ans=mid;
                high=mid-1;
            }else if(nums[mid]<target){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }return ans;
    }
    public int last(int[] nums,int target){
        int n=nums.length;
        int low=0;
        int high=n-1;
        int ans=-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(nums[mid]==target){
                ans=mid;
                low=mid+1;;
            }else if(nums[mid]<target){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }return ans;
    }
    public int[] searchRange(int[] nums, int target) {
        int f=first(nums,target);
        if(f==-1) return new int[]{-1,-1};
        int l=last(nums,target);
        return new int[]{f,l};
    }
}
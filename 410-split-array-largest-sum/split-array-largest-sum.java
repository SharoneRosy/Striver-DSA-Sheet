class Solution {
    public int splictcount(int[] nums,int maxsum){
        int n=nums.length;
        int cnt=1;
        int sum=0;
        for(int i=0;i<n;i++){
            if(sum+nums[i]<=maxsum){
                sum+=nums[i];
            }else{
                cnt+=1;
                sum=nums[i];
            }
        }return cnt;
    }
    public int splitArray(int[] nums, int k) {
        int n=nums.length;
        int sum=0;
        int maxi=Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            sum+=nums[i];
            maxi=Math.max(maxi,nums[i]);
        }

        int low=maxi;
        int high=sum;
        while(low<=high){
            int mid=(low+high)/2;
            int count=splictcount(nums,mid);
            if(count>k){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }return low;
    }
}
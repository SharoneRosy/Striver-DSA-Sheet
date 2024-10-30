// class Solution {
//     public int lengthOfLIS(int[] nums) {
//         int n=nums.length;
//         int lis[]=new int[n];
//         Arrays.fill(lis,1);
//         int max=1;
//         for(int i=0;i<n;i++){
//             for(int j=i-1;j>=0;j--){
//                 if(nums[j]<nums[i]){
//                     lis[i]=Math.max(lis[i],lis[j]+1);
//                     max=Math.max(max,lis[i]);
//                 }
//             }
//         }
//         return max;
//     }
// }

class Solution{
    public int lengthOfLIS(int [] nums){
        int n=nums.length;
        if(nums==null || nums.length==0) return 0;
        int [] dp=new int[n];
        int len=0;
         dp[len++]=nums[0];
        for(int i=1;i<n;i++){
            if(nums[i]>dp[len-1]){
                dp[len++]=nums[i];
            }else{
                int pos=lowerBound(dp,0,len-1,nums[i]);
                dp[pos]=nums[i];
            }
        }
        return len;
    }
    private int lowerBound(int [] dp,int low,int high,int target){
        while(low<=high){
            int mid=(low+high)/2;
            if(dp[mid]==target){
                return mid;
            }else if(dp[mid]<target){
                low=mid+1;
            }else{
                high=mid-1;
            }

        }
        return low;
    }
}

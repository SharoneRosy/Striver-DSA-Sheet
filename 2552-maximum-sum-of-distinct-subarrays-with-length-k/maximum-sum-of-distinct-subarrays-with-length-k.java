class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        HashMap<Integer,Integer>map=new HashMap<>();
        long ans=0;
        long currsum=0;
        int left=0;
        int right=0;
        while(right<nums.length){
            int curr=nums[right];
            int lastoccur=map.getOrDefault(curr,-1);
            
            while(left<=lastoccur || right-left+1>k){
                currsum-=nums[left];
                left++;
            }

            map.put(curr,right);
            currsum+=curr;
            if(right-left+1==k){
                ans=Math.max(ans,currsum);
            }
            right++;
        }
        return ans;
    }
}
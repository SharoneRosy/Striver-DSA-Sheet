class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int left=0;
        int right=0;
        long currsum=0;
        long max=0;
        HashMap<Integer,Integer>map=new HashMap<>();
        while (right<nums.length){
            int curr=nums[right];
            int lastoccur=map.getOrDefault(curr,-1);
            while(left<=lastoccur || right-left+1>k){
                currsum-=nums[left];
                left++;
            }
            map.put(curr,right);
            currsum+=curr;
            if(right-left+1==k){
                max=Math.max(max,currsum);
            }
            right++;
        }
        return max;
    }
}
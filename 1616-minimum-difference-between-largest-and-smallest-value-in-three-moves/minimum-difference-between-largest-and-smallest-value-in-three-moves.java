class Solution {
    public int minDifference(int[] nums) {
        if(nums.length<5) return 0;
        Arrays.sort(nums);
        int n=nums.length;
        int []res=new int[4];
        res[0]=nums[n-4]-nums[0];
         res[1]=nums[n-3]-nums[1];
          res[2]=nums[n-2]-nums[2];
           res[3]=nums[n-1]-nums[3];

        Arrays.sort(res);
        return res[0];
        
    }
}
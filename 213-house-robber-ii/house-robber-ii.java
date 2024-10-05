class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(nums.length == 1) 
            return nums[0];
       
        //We will create two arrays in first we will reject first house
        int houseFirst[] = new int[n];
        //In this array we are rejecting last house
        int houseLast[] = new int[n];
        for(int i=0;i<nums.length;i++){
            if(i!=0){
                houseFirst[i] = nums[i];
            }
            if(i!=n-1){
                houseLast[i] = nums[i];
            }
        }
        return Math.max(leavemeAlone(houseFirst),leavemeAlone(houseLast));
    }
    public int leavemeAlone(int[] nums){
        int prev = nums[0];
        int prev2 = 0;
        for(int i=1;i<nums.length;i++){
            int take = nums[i];
            if(i>1){
                take+=prev2;
            }
            int nottake = 0 + prev;
            int cur = Math.max(take,nottake);
            prev2=prev;
            prev=cur;
            
        }
        return prev;
    }
}
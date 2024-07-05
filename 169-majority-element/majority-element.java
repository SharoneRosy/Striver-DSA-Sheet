class Solution {
    public int majorityElement(int[] nums) {
        int e=nums[0];
        int c=0;
        for(int i:nums){
            
           if(i==e){
                c++;
            }
            else if(c==0){
                e=i;
                c=1;
            }else {
                c--; 
            }
        }

        return e;
    }
}
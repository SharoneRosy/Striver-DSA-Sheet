class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n=nums.length;
        int cnt=0;
        int maxi=0;
        for(int i:nums){
            if(i!=1){
                
                cnt=0;
            }else{
                cnt++;
            }
            maxi=Math.max(maxi,cnt);
        }
        return maxi;
    }
}
class Solution {
    public int majorityElement(int[] nums) {
        
        int e=0;
        int cnt=0;
        int n=nums.length;
        for(int i=0;i<nums.length;i++){
            if(cnt==0){
                e=nums[i];
                cnt++;
            }else if(e==nums[i]){
                cnt++;
            }else{
                cnt--;
            }
        }
        cnt=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==e) cnt++;
        }
        return e;
    }
}
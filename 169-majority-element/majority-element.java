class Solution {
    public int majorityElement(int[] nums) {
        int cnt=0;
        int ele=nums[0];
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]==ele){
                cnt++;
            } else{
                cnt--;
            }
            if(cnt==0){
                cnt=1;
                ele=nums[i];
            }
           
        }
       
        return ele;
        
    }
}
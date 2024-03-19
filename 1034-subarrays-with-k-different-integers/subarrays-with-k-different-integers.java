class Solution {
    public int atmost(int[] nums, int k){
        int cnt=0;
        int i=0,j=0;
        HashMap<Integer,Integer>map=new HashMap<>();
        while(j<nums.length){
            map.put(nums[j],map.getOrDefault(nums[j],0)+1);
            while(map.size()>k){
                map.put(nums[i],map.getOrDefault(nums[i],0)-1);
                if(map.get(nums[i])==0){
                    map.remove(nums[i]);
                    
                }
                i++;
            }


                cnt+=(j-i+1);
                j++;
            
        }
        return cnt;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atmost(nums,k)-atmost(nums,k-1);

        
    }
}
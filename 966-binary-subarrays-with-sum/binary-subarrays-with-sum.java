class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int presum=0;
        int cnt=0;
        
        for(int i=0;i<nums.length;i++){
            presum+=nums[i];
            if(presum==goal) cnt++;
            if(map.containsKey(presum-goal)){
                  cnt+=map.get(presum-goal);
            }
          
            map.put(presum,map.getOrDefault(presum,0)+1);
        }
        return cnt;
    }
}
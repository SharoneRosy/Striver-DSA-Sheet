class Solution {
    public int[] twoSum(int[] nums, int target) {
      
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
           int  moreNeeded=target-nums[i];
            if(map.containsKey(moreNeeded)){
               return new int[]{i,map.get(moreNeeded)};
            }
            map.put(nums[i],i);
        }
        return new int[0];
    }
}

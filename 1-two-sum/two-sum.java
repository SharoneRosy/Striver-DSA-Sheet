class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int n=nums[i];
            int rem=target-n;
            if(map.containsKey(rem)){
                return new int []{map.get(rem),i};
            }
            map.put(n,i);
        }
        return new int[]{};
    }
}
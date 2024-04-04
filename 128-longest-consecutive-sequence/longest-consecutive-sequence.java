class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer>set=new HashSet<>();
        for(int i:nums){
            set.add(i);
        }
        int max=0;
        for(int e:set){
            if(!set.contains(e-1)){
                int len=1;
                while(set.contains(++e))
                    len++;
                max=Math.max(max,len);
            }
        }
        return max;
    }
}
class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer>set=new HashSet<>();
        for(int i:nums) {
            set.add(i);
        }
        int max=0;
        for(int i:set){
            if(!set.contains(i-1)){
                int len=1;
                i=i+1;
                while(set.contains(i++)){
                    len++;
                }
                max=Math.max(max,len);
            }
        }
        return max;
    }
}
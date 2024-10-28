class Solution {
    public int longestSquareStreak(int[] nums) {
        int maxLength=-1;
        HashSet<Long>set=new HashSet<>();
        for(int i:nums) set.add((long)i);
        for(int i:nums){
            int cnt=1;
            long curr=i;
            while(curr<100000 && set.contains(curr*curr)){
                cnt++;
                curr=curr*curr;
            }
            if(cnt>=2){
                maxLength=Math.max(maxLength,cnt);
            }
        }
        return maxLength;
    }
}
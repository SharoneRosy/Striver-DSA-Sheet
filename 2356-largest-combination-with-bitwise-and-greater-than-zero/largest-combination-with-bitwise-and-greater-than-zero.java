class Solution {
    public int largestCombination(int[] candidates) {
        int max=0;
        for(int i=0;i<32;i++){
            int cnt=0;
            for(int n:candidates){
                if((n & (1<<i))!=0) cnt++;
            }
            max=Math.max(cnt,max);
        }
        return max;
    }
}
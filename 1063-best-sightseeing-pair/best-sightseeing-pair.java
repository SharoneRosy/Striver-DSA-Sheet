class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int max=0, leftmax=values[0];
        for(int i=1;i<values.length;i++){
            max=Math.max(max,leftmax+values[i]-i);
            leftmax=Math.max(leftmax,values[i]+i);
        }
        return max;
    }
}
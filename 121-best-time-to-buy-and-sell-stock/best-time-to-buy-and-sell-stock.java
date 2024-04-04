class Solution {
    public int maxProfit(int[] prices) {
        int maxP=0;
        int min=Integer.MAX_VALUE;
        int n=prices.length;
        for(int i=0;i<n;i++){
            min=Math.min(min,prices[i]);
            maxP=Math.max(maxP,prices[i]-min);
        }
        return maxP;
    }
}
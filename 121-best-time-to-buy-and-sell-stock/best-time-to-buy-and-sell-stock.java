class Solution {
    public int maxProfit(int[] prices) {
        int minbuy=prices[0];
        int maxprofit=0;
        for(int i: prices){
            minbuy=Math.min(minbuy,i);
            maxprofit=Math.max(maxprofit,i-minbuy);
        }
        return maxprofit;
    }
}
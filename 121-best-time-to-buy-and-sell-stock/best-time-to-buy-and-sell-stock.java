class Solution {
    public int maxProfit(int[] prices) {
        int min=Integer.MAX_VALUE;
        int maxProfit=Integer.MIN_VALUE;
        for(int i:prices){
            min=Math.min(i,min);
            maxProfit=Math.max(maxProfit,i-min);
        }
        return maxProfit;
    }
}


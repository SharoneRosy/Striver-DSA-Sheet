package MediumArrays;

public class stockbuysell {
    
        public static int bestTimeToBuyAndSellStock(int []prices) {
            // Write your code here.
            int maxP=0;
            int n=prices.length;
            int min=Integer.MAX_VALUE;
            for(int i=0;i<n;i++){
                min=Math.min(min,prices[i]);
                maxP=Math.max(maxP, prices[i]-min);
            }
            return maxP;
        }
    }
    


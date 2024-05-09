class Solution {
   public static int f(int i, int j, ArrayList<Integer> newCuts,int [][]dp){
           if(i > j) return 0;
           if(dp[i][j]!=-1) return dp[i][j];
           int min = (int)(1e9);
           for(int k = i; k <= j; k++){
               int cost = (newCuts.get(j + 1) - newCuts.get(i - 1)) + f(i, k - 1, newCuts,dp) + f(k + 1, j, newCuts,dp);
               min = Math.min(min, cost); 
           }
   
           return dp[i][j]=min;
       }
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        ArrayList<Integer>newCuts=new ArrayList<>();
        newCuts.add(0);
        for(int i:cuts) newCuts.add(i);
        newCuts.add(n);
        int m=cuts.length;
       
          int[][] dp = new int[m + 2][m + 2];
        
        for(int i = m; i >= 1; i--){
            for(int j = i; j <= m; j++){
                int min = (int)(1e9);
                for(int k = i; k <= j; k++){
                    int cost = (newCuts.get(j + 1) - newCuts.get(i - 1)) + dp[i][k - 1] + dp[k + 1][j];
                    min = Math.min(min, cost); 
                }

                dp[i][j] = min;
            }
        }

        return dp[1][m];
    }
}
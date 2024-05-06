class Solution {
    public int f(String s,String t,int i,int j,int [][]dp){
        if(j==0) return 1;
        if (i==0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s.charAt(i-1)==t.charAt(j-1)){
           return  dp[i][j]=f(s,t,i-1,j-1,dp)+f(s,t,i-1,j,dp);
        }else{
            return dp[i][j]=f(s,t,i-1,j,dp);
        }
    }
        public static int numDistinct(String s, String t) {
        int n = s.length(), m = t.length();
        int[] dp = new int[m + 1];
        
        // base case
        dp[0] = 1;

        for(int i = 1; i <= n; i++){
            // we have to move j in reverse so that values in dp can't be overriden
            for(int j = m; j >= 1; j--){
                if(s.charAt(i - 1) == t.charAt(j - 1)){
                    // max of take or notTake(if characters are same)
                    dp[j] = dp[j - 1] + dp[j];
                }
                // else not required (dp[j] = dp[j]) no sense of doing this
            }
        }
        return dp[m];
    }    

}
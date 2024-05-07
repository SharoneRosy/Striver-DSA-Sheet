class Solution {
    public static boolean isAllStars(String p, int idx){
           while(idx >= 0) {
               if(p.charAt(idx--) != '*') return false;
           } 
           return true;
       }
   
       public static boolean helper(int i, int j, String s, String p, Boolean[][] dp){
           if(i < 0 && j < 0) return true;
           else if(i < 0 && j >= 0) return isAllStars(p, j);
           else if(j < 0 && i >= 0) return false;
   
           if(dp[i][j] != null) return dp[i][j];
   
           if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?'){
               return dp[i][j] = helper(i - 1, j - 1, s, p, dp);
           }
           else if(p.charAt(j) == '*'){
               return dp[i][j] = helper(i, j - 1, s, p, dp) || helper(i - 1, j, s, p, dp);
           }    
           return dp[i][j] = false;    
       }
   
       public static boolean isMatch(String s, String p) {
           int n = s.length();
           int m = p.length();
           Boolean[][] dp = new Boolean[n][m];
           return helper(n - 1, m - 1, s, p, dp);
       }
}
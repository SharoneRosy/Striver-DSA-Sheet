class Solution {
    public int f(String t1,String t2,int n,int m, int [][]dp){
        if(n<=0 || m<=0) return 0;
        if(dp[n][m]!=-1) return dp[n][m];
        if(t1.charAt(n-1)==t2.charAt(m-1)){
            return  dp[n][m]=1+f(t1,t2,n-1,m-1,dp);
        }
        return dp[n][m]= 0+Math.max(f(t1,t2,n-1,m,dp),f(t1,t2,n,m-1,dp));

    }
    public int longestCommonSubsequence(String t1, String t2) {
        int n=t1.length();
        int m=t2.length();
        int dp[][]=new int[n+1][m+1];
        for(int [] it:dp){
            Arrays.fill(it,-1);
        }
        return f(t1,t2,n,m,dp);
    }
}

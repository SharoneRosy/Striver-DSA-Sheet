class Solution {
    public int f(int i,int j,String s,String t,int [][]dp){
        if(i<0) return j+1;
        if(j<0) return i+1;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s.charAt(i)==t.charAt(j)){
            return dp[i][j]=f(i-1,j-1,s,t,dp);
        }else{
            return dp[i][j]= 1+Math.min(f(i-1,j,s,t,dp),
                               Math.min( f(i,j-1,s,t,dp),
                                    f(i-1,j-1,s,t,dp)));
        }
    }
    public int minDistance(String s, String t) {
        int n=s.length();
        int m=t.length();
        int dp[][]=new int[n][m];
        for(int []it :dp) Arrays.fill(it,-1);
        return f(n-1,m-1,s,t,dp);
    }
}
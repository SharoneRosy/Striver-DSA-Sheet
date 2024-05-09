class Solution {
    public boolean isPali(int i,int j,String s){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)) return false;
            else {
                i++;
                j--;
            }
        }
        return true;
    }
    public int f(int i,int n,String s,int []dp){
        if(i==n) return 0;
        int mini=Integer.MAX_VALUE;
        if(dp[i]!=-1) return dp[i];
        for(int j=i;j<n;j++){
            if(isPali(i,j,s)){
                int val= 1+f(j+1,n,s,dp);
                mini=Math.min(mini,val);
            }
        }
        return dp[i]= mini;
    }
    public int minCut(String s) {
        int n=s.length();
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        return f(0,n,s,dp)-1;
    }
}
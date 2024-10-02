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
        int dp[]=new int[n+1];
        Arrays.fill(dp,0);
        dp[n]=0;
        for(int i=n-1;i>=0;i--){
            int mini=Integer.MAX_VALUE;
            
            for(int j=i;j<n;j++){
                if(isPali(i,j,s)){
                    int val= 1+dp[j+1];
                    mini=Math.min(mini,val);
                }
            }
           dp[i]= mini;
        }
        return dp[0]-1;
    }
}
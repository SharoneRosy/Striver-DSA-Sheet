class Solution {
    public int solve(int i,int j,int [][] dp){
        if(i==0 && j==0) return 1;
        if(i<0 || j<0) return 0;
        if(dp[i][j] !=-1) return dp[i][j];
        int left=solve(i,j-1,dp);
        int up=solve(i-1,j,dp);
        dp[i][j]=left+up;
        return dp[i][j];
    }
    public int uniquePaths(int m, int n) {
        int [][] dp=new int[m][n];
        for(int [] row:dp) Arrays.fill(row,-1);
        //return solve(m-1,n-1,dp);

        //Tablulation
        for(int i=0;i<n;i++){
            dp[0][i]=1;
        }
        for(int j=0;j<m;j++){
            dp[j][0]=1;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        // return dp[m-1][n-1];


        //Space Optimization
        int [] prev=new int[n+1];
        int [] curr=new int[n+1];

        for(int i=0;i<n;i++){
            prev[i]=1;
        }
        for(int j=0;j<m;j++){
            curr[0]=1;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                curr[j]=prev[j]+curr[j-1];
            }
            prev=curr.clone();
        }
        return prev[n-1];

    }
}
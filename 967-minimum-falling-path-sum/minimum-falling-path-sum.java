class Solution {
    public static int minFallingPathSum(int[][] matrix) {

           int n=matrix.length;
           int [][]dp=new int[n][n];
           for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==0) dp[i][j]=matrix[i][j];
                else{
                    int s=Integer.MAX_VALUE,ld=Integer.MAX_VALUE,rd=Integer.MAX_VALUE;
                    if(i-1>=0 ) s=dp[i-1][j];
                    if(i-1>=0 && j-1>=0) ld=dp[i-1][j-1];
                    if(i-1>=0 && j+1<n) rd=dp[i-1][j+1];
                    dp[i][j]=matrix[i][j]+Math.min(s,Math.min(ld,rd));
                }
            }
           }
           int min=Integer.MAX_VALUE;
           for(int j=0;j<n;j++){
            min=Math.min(min,dp[n-1][j]);
           }
           return min;
       }
}
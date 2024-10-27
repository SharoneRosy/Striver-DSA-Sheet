class Solution {
    public int countSquares(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int [][]dp=new int[m][n];
        int cnt=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==1){
                int lefttop=(i>0 && j>0) ? dp[i-1][j-1]:0;
                int top=(i>0)?dp[i-1][j]:0;
                int left=(j>0)?dp[i][j-1]:0;
                dp[i][j]=Math.min(lefttop,Math.min(left,top))+1;
                cnt+=dp[i][j];
                }
            }
        }
        return cnt;
    }
}
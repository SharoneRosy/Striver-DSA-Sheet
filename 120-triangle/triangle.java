class Solution {
    public int f(int i,int j,int [][]dp, List<List<Integer>> triangle){
        if(i==triangle.size()-1) return triangle.get(i).get(j);
        if(dp[i][j]!=-1) return dp[i][j];
        int down=f(i+1,j,dp,triangle);
        int dg=f(i+1,j+1,dp,triangle);
        return dp[i][j]=triangle.get(i).get(j)+Math.min(down,dg);
        
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int dp[][]=new int[n+1][n+1];
        for(int[] it:dp){
            Arrays.fill(it,-1);
        }
        return f(0,0,dp,triangle);
    }
}
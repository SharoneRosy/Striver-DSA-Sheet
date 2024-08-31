 class Solution {
    private int memoization(String s, String p, int i, int j, int[][] dp){
        if(i<0 && j<0) return 1;
        if(i<0 && j>=0){
             for(int x=0; x<=j; x++){
                if(p.charAt(x) != '*') return 0;
            }
            return 1;
        };
        if(j<0) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?'){
            return dp[i][j] = memoization(s, p ,i-1, j-1, dp);
        }
        if(p.charAt(j) == '*'){
            return dp[i][j] = memoization(s, p, i-1, j, dp) == 1 || memoization(s, p, i, j-1, dp) == 1 ? 1 : 0;
        }

        return dp[i][j] = 0;
    }
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        int[][] dp = new int[n][m];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }

        return memoization(s, p, n-1, m-1, dp) == 1 ? true: false;
    }
}
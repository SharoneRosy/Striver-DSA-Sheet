class Solution {
    private int[][] memo;

    public int strangePrinter(String s) {
        int n = s.length();
        memo = new int[n][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return minPrints(s, 0, n - 1);
    }

    private int minPrints(String s, int i, int j) {
        if (i > j) return 0;
        if (i == j) return 1;
        if (memo[i][j] != -1) return memo[i][j];

        int ans = minPrints(s, i, j - 1) + 1; // Assume the last character is printed separately

        for (int k = i; k < j; k++) {
            if (s.charAt(k) == s.charAt(j)) {
                ans = Math.min(ans, minPrints(s, i, k) + minPrints(s, k + 1, j - 1));
            }
        }

        memo[i][j] = ans;
        return ans;
    }
}

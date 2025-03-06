class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        boolean[] seen = new boolean[n * n + 1];
        int[] ans = new int[2];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(seen[grid[i][j]]) {
                    ans[0] = grid[i][j];
                } else {
                    seen[grid[i][j]] = true;
                }
            }
        }
        for(int i = 1; i < n*n + 1; i++) {
            if(!seen[i]) {
                ans[1] = i;
                break;
            }
        }
        return ans;
    }
}
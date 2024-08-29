class Solution {
    int m, n;
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        m = grid1.length;
        n = grid1[0].length;
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1) {
                    if (solve(i, j, grid1, grid2)) res++;
                }
            }
        }
        return res;
    }

    private boolean solve(int i, int j, int[][] grid1, int[][] grid2) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid2[i][j] == 0) return true;

        if (grid1[i][j] == 0) return false;

        grid2[i][j] = 0;

        boolean top = solve(i + 1, j, grid1, grid2);
        boolean down = solve(i - 1, j, grid1, grid2);
        boolean right = solve(i, j + 1, grid1, grid2);
        boolean left = solve(i, j - 1, grid1, grid2);

        return top && down && right && left;
    }
}
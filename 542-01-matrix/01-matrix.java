class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        Queue<int[]> q = new LinkedList<>();
        int drow[] = {1, -1, 0, 0};
        int dcol[] = {0, 0, 1, -1};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    q.add(new int[]{i, j});
                } else {
                    mat[i][j] = -1;
                }
            }
        }

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                int row = curr[0];
                int col = curr[1];

                for (int k = 0; k < 4; k++) {
                    int nrow = row + drow[k];
                    int ncol = col + dcol[k];
                    if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && mat[nrow][ncol] == -1) {
                        mat[nrow][ncol] = mat[row][col] + 1;
                        q.add(new int[]{nrow, ncol});
                    }
                }
            }
        }

        return mat;
    }
}

class Solution {
    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        Queue<int[]> q = new LinkedList<>();
        int[] drow = {1, -1, 0, 0};
        int[] dcol = {0, 0, 1, -1};

        // Add all boundary 'O's to the queue and mark them as 'P'
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') q.add(new int[]{i, 0});
            if (board[i][n - 1] == 'O') q.add(new int[]{i, n - 1});
        }
        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O') q.add(new int[]{0, i});
            if (board[m - 1][i] == 'O') q.add(new int[]{m - 1, i});
        }

        // Perform BFS for all boundary 'O's
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int row = curr[0], col = curr[1];
            board[row][col] = 'P';
            for (int k = 0; k < 4; k++) {
                int nrow = row + drow[k];
                int ncol = col + dcol[k];
                if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && board[nrow][ncol] == 'O') {
                    q.add(new int[]{nrow, ncol});
                }
            }
        }

        // Process the board to finalize the changes
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'P') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
}

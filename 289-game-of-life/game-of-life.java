
class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;
        Queue<int[]> queue = new LinkedList<>();

        // Step 1: Identify cells that need changes
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int liveNeighbors = countLiveNeighbors(board, i, j, m, n);

                if (board[i][j] == 1) { // Live cell
                    if (liveNeighbors < 2 || liveNeighbors > 3) {
                        queue.add(new int[]{i, j, 0}); // Mark for death
                    }
                } else { // Dead cell
                    if (liveNeighbors == 3) {
                        queue.add(new int[]{i, j, 1}); // Mark for revival
                    }
                }
            }
        }

        // Step 2: Apply changes simultaneously
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            board[cell[0]][cell[1]] = cell[2]; // Update board state
        }
    }

    private int countLiveNeighbors(int[][] board, int i, int j, int m, int n) {
        int count = 0;

        for (int dr = -1; dr <= 1; dr++) {  // Iterate row changes from -1 to 1
            for (int dc = -1; dc <= 1; dc++) {  // Iterate column changes from -1 to 1
                if (dr == 0 && dc == 0) continue; // Skip the cell itself
                
                int newRow = i + dr;
                int newCol = j + dc;

                if (newRow >= 0 && newCol >= 0 && newRow < m && newCol < n && board[newRow][newCol] == 1) {
                    count++;
                }
            }
        }
        return count;
    }
}

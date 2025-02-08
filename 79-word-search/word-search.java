class Solution {
    private int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // Directions: right, down, left, up

    public boolean exist(char[][] board, String word) {
        int rows = board.length, cols = board[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(board, i, j, word, 0)) return true; // Start DFS if the first letter matches
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int x, int y, String word, int index) {
        if (index == word.length()) return true; // Found the word
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) return false; // Out of bounds
        if (board[x][y] != word.charAt(index)) return false; // Current cell does not match the word's current character

        char temp = board[x][y]; // Save the character
        board[x][y] = '#'; // Mark the cell as visited

        for (int[] dir : directions) { // Explore all possible directions
            int newX = x + dir[0], newY = y + dir[1];
            if (dfs(board, newX, newY, word, index + 1)) return true; // Recur to check the next character in the word
        }

        board[x][y] = temp; // Restore the original character for backtracking
        return false;
    }
}

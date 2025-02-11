import java.util.*;

class Solution {
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        // Edge case where the starting or ending point is blocked and cannot eliminate any obstacles
        if (grid[0][0] == 1 && k == 0 || grid[m-1][n-1] == 1 && k == 0) return -1;

        // Directions array for moving in the grid (up, down, left, right)
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        // Queue for BFS that holds int array: [current row, current column, remaining obstacles you can remove, steps]
        Queue<int[]> queue = new LinkedList<>();
        // Start from the top-left corner of the grid
        queue.add(new int[]{0, 0, k, 0});

        // A 3D boolean array to keep track of visited positions with a specific remaining obstacle removals
        boolean[][][] visited = new boolean[m][n][k + 1];
        visited[0][0][k] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0], col = current[1], obstaclesLeft = current[2], steps = current[3];

            // If we reach the bottom-right corner, return the number of steps taken
            if (row == m - 1 && col == n - 1) {
                return steps;
            }

            for (int[] dir : directions) {
                int newRow = row + dir[0], newCol = col + dir[1];

                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n) {
                    int newObstaclesLeft = obstaclesLeft - grid[newRow][newCol];
                    // Only proceed if the new position is within grid bounds and we have not visited it with more or equal remaining obstacle removals or can still go through
                    if (newObstaclesLeft >= 0 && !visited[newRow][newCol][newObstaclesLeft]) {
                        queue.add(new int[]{newRow, newCol, newObstaclesLeft, steps + 1});
                        visited[newRow][newCol][newObstaclesLeft] = true;
                    }
                }
            }
        }

        // If no path was found, return -1
        return -1;
    }
}

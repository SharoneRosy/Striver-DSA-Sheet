import java.util.*;

class Solution {
    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length, cols = heights[0].length;

        // Directions for moving in 4 possible directions (up, down, left, right)
        int[] dRow = {-1, 1, 0, 0};
        int[] dCol = {0, 0, -1, 1};

        // Min-heap for Dijkstra's algorithm
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]); // [effort, row, col]
        pq.add(new int[]{0, 0, 0}); // Start with effort 0 at (0, 0)

        // Distance array to track minimum effort to each cell
        int[][] dist = new int[rows][cols];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);
        dist[0][0] = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int effort = curr[0], r = curr[1], c = curr[2];

            // If we reach the bottom-right corner, return the effort
            if (r == rows - 1 && c == cols - 1) return effort;

            // Explore neighbors
            for (int i = 0; i < 4; i++) {
                int nr = r + dRow[i];
                int nc = c + dCol[i];

                // Check if neighbor is within bounds
                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols) {
                    int newEffort = Math.max(effort, Math.abs(heights[nr][nc] - heights[r][c]));
                    if (newEffort < dist[nr][nc]) {
                        dist[nr][nc] = newEffort;
                        pq.add(new int[]{newEffort, nr, nc});
                    }
                }
            }
        }

        return 0; // Unreachable case
    }
}

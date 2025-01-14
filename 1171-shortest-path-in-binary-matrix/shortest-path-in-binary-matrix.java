class Node {
    int row, col, distance;

    Node(int row, int col, int distance) {
        this.row = row;
        this.col = col;
        this.distance = distance;
    }
}

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1; // Start or end cell is blocked
        }
        if (n == 1) {
            return 1; // Single cell grid
        }

        // Directions for moving in 8 possible directions
        int[] dRow = {-1, 0, 1, 0, 1, 1, -1, -1};
        int[] dCol = {0, 1, 0, -1, -1, 1, -1, 1};

        // Initialize distance matrix with a very high value
        int[][] distance = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }
        distance[0][0] = 1; // Starting cell distance is 1

        // BFS queue
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, 1)); // Start from top-left corner

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            int row = current.row;
            int col = current.col;
            int dist = current.distance;

            // Explore all 8 possible directions
            for (int i = 0; i < 8; i++) {
                int newRow = row + dRow[i];
                int newCol = col + dCol[i];

                // Check if the new cell is within bounds and valid
                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n
                        && grid[newRow][newCol] == 0 && dist + 1 < distance[newRow][newCol]) {
                    distance[newRow][newCol] = dist + 1;

                    // Check if we've reached the bottom-right corner
                    if (newRow == n - 1 && newCol == n - 1) {
                        return dist + 1;
                    }
                    queue.add(new Node(newRow, newCol, dist + 1));
                }
            }
        }

        return -1; // If no path exists
    }
}

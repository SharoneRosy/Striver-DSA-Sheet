import java.util.*;

class Solution {
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        DisjointSet ds = new DisjointSet(n * n);

        // Direction arrays for traversing 4 neighbors
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, -1, 0, 1};

        // Step 1: Group all connected components and union their nodes
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 1) {
                    int nodeNo = row * n + col; // Unique ID for the cell
                    for (int dir = 0; dir < 4; dir++) {
                        int newRow = row + dr[dir];
                        int newCol = col + dc[dir];
                        if (isValid(newRow, newCol, n) && grid[newRow][newCol] == 1) {
                            int adjNodeNo = newRow * n + newCol;
                            ds.unionBySize(nodeNo, adjNodeNo);
                        }
                    }
                }
            }
        }

        // Step 2: Calculate the size of the largest island
        int maxSize = 0;

        // Traverse the grid and calculate the largest island size
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 0) {
                    HashSet<Integer> components = new HashSet<>();

                    // Check all 4 neighbors
                    for (int dir = 0; dir < 4; dir++) {
                        int newRow = row + dr[dir];
                        int newCol = col + dc[dir];
                        if (isValid(newRow, newCol, n) && grid[newRow][newCol] == 1) {
                            int componentId = ds.findParent(newRow * n + newCol);
                            components.add(componentId);
                        }
                    }

                    // Sum up the sizes of all unique components
                    int currentSize = 1; // Changing the current `0` to `1`
                    for (int component : components) {
                        currentSize += ds.getSize(component);
                    }

                    // Update maxSize
                    maxSize = Math.max(maxSize, currentSize);
                }
            }
        }

        // If the grid is already filled with `1`s
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 1) {
                    int nodeNo = row * n + col;
                    maxSize = Math.max(maxSize, ds.getSize(ds.findParent(nodeNo)));
                }
            }
        }

        return maxSize;
    }

    private boolean isValid(int row, int col, int n) {
        return row >= 0 && row < n && col >= 0 && col < n;
    }
}

class DisjointSet {
    private int[] parent, size;

    public DisjointSet(int n) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int findParent(int node) {
        if (parent[node] != node) {
            parent[node] = findParent(parent[node]); // Path compression
        }
        return parent[node];
    }

    public void unionBySize(int u, int v) {
        int rootU = findParent(u);
        int rootV = findParent(v);

        if (rootU != rootV) {
            if (size[rootU] < size[rootV]) {
                parent[rootU] = rootV;
                size[rootV] += size[rootU];
            } else {
                parent[rootV] = rootU;
                size[rootU] += size[rootV];
            }
        }
    }

    public int getSize(int node) {
        return size[findParent(node)];
    }
}

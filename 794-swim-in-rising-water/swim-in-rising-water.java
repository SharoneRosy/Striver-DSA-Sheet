import java.util.*;

class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        DisjointSet dsu = new DisjointSet(n * n);

        // Priority queue to process cells in increasing order of elevation
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> grid[a[0]][a[1]] - grid[b[0]][b[1]]);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                pq.add(new int[]{i, j});
            }
        }

        // Directions for 4-way movement
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};

        while (!pq.isEmpty()) {
            int[] cell = pq.poll();
            int x = cell[0], y = cell[1];
            int time = grid[x][y];

            // Union this cell with its adjacent cells if they are within time constraints
            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && grid[nx][ny] <= time) {
                    dsu.union(x * n + y, nx * n + ny);
                }
            }

            // If the top-left (0,0) and bottom-right (n-1,n-1) are connected, return the current time
            if (dsu.find(0) == dsu.find(n * n - 1)) {
                return time;
            }
        }

        return -1; // This line should never be reached
    }
}

class DisjointSet {
    int[] parent, size;

    public DisjointSet(int n) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int node) {
        if (node != parent[node]) {
            parent[node] = find(parent[node]); // Path compression
        }
        return parent[node];
    }

    public void union(int u, int v) {
        int rootU = find(u);
        int rootV = find(v);

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
}

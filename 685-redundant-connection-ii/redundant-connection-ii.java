class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        UnionFind uf = new UnionFind(n);
        int[] parent = new int[n + 1]; // To track the parent node of each node
        int[] cand1 = null; // First candidate edge for removal
        int[] cand2 = null; // Second candidate edge for removal

        // Identify potential nodes with two parents
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            if (parent[v] > 0) {
                cand1 = new int[]{parent[v], v};
                cand2 = new int[]{u, v};
                edge[1] = 0; // Temporarily disable this edge
            } else {
                parent[v] = u;
            }
        }

        // Attempt to build the tree using union-find
        for (int[] edge : edges) {
            if (edge[1] == 0) continue; // Skip the disabled edge
            int u = edge[0], v = edge[1];
            if (!uf.union(u, v)) { // If union fails, it means a cycle
                return cand1 == null ? edge : cand1; // If no two parents, return this edge; else return the first candidate
            }
        }

        return cand2; // If there was a temporary disabled edge, return it
    }

    class UnionFind {
        private int[] parent;
        private int[] rank;

        public UnionFind(int size) {
            parent = new int[size + 1];
            rank = new int[size + 1];
            for (int i = 0; i <= size; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]); // Path compression
            }
            return parent[x];
        }

        public boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) return false; // Cycle detected
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
            return true;
        }
    }
}

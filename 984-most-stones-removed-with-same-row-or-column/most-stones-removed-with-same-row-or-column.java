import java.util.*;

class Solution {
    public int removeStones(int[][] stones) {
        int totalStones = stones.length;
        int maxRow = 0, maxCol = 0;

        // Find the maximum row and column indices for Union-Find size
        for (int[] stone : stones) {
            maxRow = Math.max(maxRow, stone[0]);
            maxCol = Math.max(maxCol, stone[1]);
        }

        // Initialize Union-Find
        DisjointSet ds = new DisjointSet(maxRow + maxCol + 1);
        Map<Integer, Integer> uniqueNodes = new HashMap<>();

        // Union stones based on row and column
        for (int[] stone : stones) {
            int rowNode = stone[0];
            int colNode = stone[1] + maxRow + 1; // Offset column indices
            ds.unionBySize(rowNode, colNode);
            uniqueNodes.put(rowNode, 1); // Track unique nodes
            uniqueNodes.put(colNode, 1);
        }

        // Count the number of connected components
        int componentCount = 0;
        for (int node : uniqueNodes.keySet()) {
            if (ds.findParent(node) == node) {
                componentCount++;
            }
        }

        // Maximum stones removed = total stones - number of connected components
        return totalStones - componentCount;
    }
}

class DisjointSet {
    private List<Integer> parent;
    private List<Integer> size;

    public DisjointSet(int totalNodes) {
        parent = new ArrayList<>(totalNodes + 1);
        size = new ArrayList<>(totalNodes + 1);

        // Initialize parent and size for each node
        for (int i = 0; i <= totalNodes; i++) {
            parent.add(i);
            size.add(1);
        }
    }

    // Find parent of a node with path compression
    public int findParent(int node) {
        if (parent.get(node) == node) {
            return node;
        }
        int root = findParent(parent.get(node));
        parent.set(node, root); // Path compression
        return root;
    }

    // Union two nodes by size
    public void unionBySize(int node1, int node2) {
        int root1 = findParent(node1);
        int root2 = findParent(node2);

        if (root1 != root2) {
            // Attach the smaller tree to the larger tree
            if (size.get(root1) < size.get(root2)) {
                parent.set(root1, root2);
                size.set(root2, size.get(root2) + size.get(root1));
            } else {
                parent.set(root2, root1);
                size.set(root1, size.get(root1) + size.get(root2));
            }
        }
    }
}

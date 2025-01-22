import java.util.*;

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> reverseGraph = new ArrayList<>();
        List<Integer> safeNodes = new ArrayList<>();
        int[] indegree = new int[n];
        Queue<Integer> queue = new LinkedList<>();

        // Step 1: Build the reverse graph and calculate indegree
        for (int i = 0; i < n; i++) {
            reverseGraph.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int neighbor : graph[i]) {
                reverseGraph.get(neighbor).add(i);
                indegree[i]++;
            }
        }

        // Step 2: Add all terminal nodes (indegree 0) to the queue
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        // Step 3: Process nodes using BFS
        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            safeNodes.add(currentNode);

            for (int dependentNode : reverseGraph.get(currentNode)) {
                indegree[dependentNode]--;
                if (indegree[dependentNode] == 0) {
                    queue.add(dependentNode);
                }
            }
        }

        // Step 4: Sort the safe nodes
        Collections.sort(safeNodes);
        return safeNodes;
    }
}

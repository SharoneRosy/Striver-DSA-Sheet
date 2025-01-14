import java.util.*;
class Pair {
    long distance;
    int node;

    Pair(long distance, int node) {
        this.distance = distance;
        this.node = node;
    }
}

class Solution {
    public int countPaths(int n, int[][] roads) {
        final int MOD = 1_000_000_007;

        // Step 1: Build the adjacency list
        List<List<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] road : roads) {
            graph.get(road[0]).add(new Pair(road[2], road[1])); // {time, destination}
            graph.get(road[1]).add(new Pair(road[2], road[0])); // {time, destination}
        }

        // Step 2: Initialize distances and ways arrays
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;

        int[] ways = new int[n];
        ways[0] = 1;

        // Step 3: Min-heap for Dijkstra's algorithm
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Long.compare(a.distance, b.distance));
        pq.add(new Pair(0, 0)); // {distance, node}

        // Step 4: Process nodes
        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            long currentDist = current.distance;
            int node = current.node;

            // Skip if we've already processed a shorter path
            if (currentDist > dist[node]) continue;

            // Explore neighbors
            for (Pair neighbor : graph.get(node)) {
                long newDist = currentDist + neighbor.distance;
                int nextNode = neighbor.node;

                // Found a shorter path
                if (newDist < dist[nextNode]) {
                    dist[nextNode] = newDist;
                    ways[nextNode] = ways[node];
                    pq.add(new Pair(newDist, nextNode));
                }
                // Found another shortest path
                else if (newDist == dist[nextNode]) {
                    ways[nextNode] = (ways[nextNode] + ways[node]) % MOD;
                }
            }
        }

        // Return the number of ways to reach the destination
        return ways[n - 1];
    }
}

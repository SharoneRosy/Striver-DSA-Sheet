import java.util.*;
class Pair {
    int city, cost;

    Pair(int city, int cost) {
        this.city = city;
        this.cost = cost;
    }
}
class Tuple {
    int stops, city, cost;

    Tuple(int stops, int city, int cost) {
        this.stops = stops;
        this.city = city;
        this.cost = cost;
    }
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // Step 1: Build the adjacency list
        List<List<Pair>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] flight : flights) {
            adjList.get(flight[0]).add(new Pair(flight[1], flight[2]));
        }

        // Step 2: Initialize distance array and BFS queue
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        Queue<Tuple> queue = new LinkedList<>();
        queue.add(new Tuple(0, src, 0)); // {stops, city, cost}

        // Step 3: BFS traversal
        while (!queue.isEmpty()) {
            Tuple current = queue.poll();
            int stops = current.stops;
            int city = current.city;
            int cost = current.cost;

            // If stops exceed k, skip
            if (stops > k) continue;

            // Explore neighbors
            for (Pair neighbor : adjList.get(city)) {
                int nextCity = neighbor.city;
                int nextCost = neighbor.cost;

                // If a cheaper path is found, update and add to queue
                if (cost + nextCost < dist[nextCity]) {
                    dist[nextCity] = cost + nextCost;
                    queue.add(new Tuple(stops + 1, nextCity, cost + nextCost));
                }
            }
        }
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}

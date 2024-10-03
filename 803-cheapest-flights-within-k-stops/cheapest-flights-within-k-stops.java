class Pair {
    int first;
    int second;

    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Tuple {
    int first;
    int second;
    int third;

    Tuple(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        // Create an adjacency list to represent the graph.
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        int m = flights.length;

        // Populate the adjacency list with flight information.
        for (int i = 0; i < m; i++) {
            adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
        }

        // Initialize a queue for BFS and an array to store minimum distances.
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(0, src, 0)); 
        int dist[] = new int[n];

        for (int i = 0; i < n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        // The distance from the source to itself is zero.
        dist[src] = 0;

        // Perform BFS to find the shortest path.
        while (!q.isEmpty()) {
            Tuple it = q.peek();
            q.poll();

            int stop = it.first;
            int node = it.second;
            int cost = it.third;

            // If the number of stops exceeds k, skip this node.
            if (stop > k) continue;

            for (Pair iter : adj.get(node)) {
                int adjNode = iter.first;
                int edW = iter.second;

                // If the current path is shorter, update the distance and add to the queue.
                if (cost + edW < dist[adjNode] && stop <= k) {
                    dist[adjNode] = cost + edW;
                    q.add(new Tuple(stop + 1, adjNode, cost + edW));
                }
            }
        }
        
        // If there is no valid path to the destination, return -1.
        if (dist[dst] == Integer.MAX_VALUE) return -1;

        // Return the minimum cost to reach the destination.
        return dist[dst];
    }
}
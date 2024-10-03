class Solution {    
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] shortestPath = new int[n][n];

        // Intializing Distance graph;
        for (int i = 0; i < n; i++) {
            Arrays.fill(shortestPath[i], Integer.MAX_VALUE);
            shortestPath[i][i] = 0;
        }

        //Adding edge weight to the graph to compute shortest path;
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];
            shortestPath[u][v] = w;
            shortestPath[v][u] = w;
        }

        // Pre-computing shortest path using floydd warshal algorithm
        for(int k = 0; k < n; k++) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(shortestPath[i][k] != Integer.MAX_VALUE && shortestPath[k][j] != Integer.MAX_VALUE) {
                        shortestPath[i][j] = Math.min(shortestPath[i][j], 
                                                      shortestPath[i][k] + shortestPath[k][j]);
                    }
                }
            }
        }


        //finding the result
        int minCount = Integer.MAX_VALUE;
        int res = -1;
        for(int i = 0; i < n; i++) {
            int count = 0;
            for(int j = 0; j < n; j++) {
                if(i != j && shortestPath[i][j] <= distanceThreshold) {
                    count++;
                }
            }
            if(count <= minCount) {
                res = Math.max(res, i);
                minCount = count;
            }
        }

        return res;
    }
}
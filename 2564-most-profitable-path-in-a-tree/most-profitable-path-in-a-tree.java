class Solution {
    List<List<Integer>> graph;
    List<Integer> bobPath;

    // DFS to find Bob's path from bob to root (0)
    boolean dfs(int curr, int par, int bob) {
        if(curr == bob) return true;

        for(int next: graph.get(curr)) {
            if(next != par) {
                if(dfs(next, curr, bob)) {
                    bobPath.add(next);
                    return true;
                }
            }
        }

        return false;
    }

    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n = amount.length;
        graph = new ArrayList<>();
        for(int i = 0; i < n; ++i) graph.add(new ArrayList<>());
        
        // Construct the graph
        for(int[] edge: edges) {
            int u = edge[0], v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // Find Bob's path to root (0)
        bobPath = new ArrayList<>();
        dfs(0, -1, bob);
        bobPath.add(0);

        // BFS to find maximum profit for Alice
        int maxScore = Integer.MIN_VALUE;
        int depth = 1;
        Queue<Integer> que = new LinkedList<>();
        que.add(0);
        int[] score = new int[n];
        score[0] = amount[0];
        amount[bob] = 0;  // Bob's starting node contributes nothing to Alice

        boolean[] vis = new boolean[n];
        vis[0] = true;

        while(!que.isEmpty()) {
            if(depth < bobPath.size()) {
                amount[bobPath.get(depth)] /= 2;  // Alice and Bob reach at the same time
            }

            int size = que.size();
            while(size-- > 0) {
                int curr = que.poll();
                boolean isLeaf = true;

                for(int next: graph.get(curr)) {
                    if(!vis[next]) {
                        isLeaf = false;
                        vis[next] = true;
                        score[next] = score[curr] + amount[next];
                        que.add(next);
                    }
                }

                if(isLeaf) {
                    maxScore = Math.max(maxScore, score[curr]);
                }
            }

            if(depth < bobPath.size()) {
                amount[bobPath.get(depth)] = 0;  // Bob reaches before Alice
            }
            ++depth;
        }

        return maxScore;
    }
}
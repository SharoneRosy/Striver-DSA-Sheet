class Solution {
    class edge{
        int src,dest,wt;
        public edge(int src,int dest,int wt){
            this.src=src;
            this.dest=dest;
            this.wt=wt;
        }
    }
    public int dijkstras(ArrayList<edge>[] graph,int src){
        int dist[] = new int[graph.length+1];
        boolean vis[] = new boolean[graph.length+1];
        for(int i=0;i<dist.length;i++){
            if(i!=src){
                dist[i] =Integer.MAX_VALUE;
            }
        }
        PriorityQueue<Pair<Integer,Integer>> pq = new PriorityQueue<>((a,b)->(Integer.compare(a.getValue(),b.getValue())));
        pq.add(new Pair(src,0));
        while(!pq.isEmpty()){
            Pair<Integer,Integer> p = pq.remove();
            int curr=p.getKey();
            int d=p.getValue();
            if(!vis[curr]){
                vis[curr]=true;
                for(int i=0;i<graph[curr].size();i++){
                    edge e = graph[curr].get(i);
                    int v = e.src;
                    int u = e.dest;
                    int w = e.wt;
                    if((dist[v]+w)<dist[u]){
                        dist[u] = dist[v]+w;
                        pq.add(new Pair(u,dist[u]));
                    }
                }
            }
        }
        int maxDist = 0;
        for (int i = 1; i < graph.length; i++) {
            if (dist[i] == Integer.MAX_VALUE) return Integer.MAX_VALUE;
            maxDist = Math.max(maxDist, dist[i]);
        }
        return maxDist;

    }
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<edge>[] graph=new ArrayList[n+1];
        for(int i=0;i<n+1;i++){
            graph[i] = new ArrayList<>();
        }
         for (int[] time : times) {
            graph[time[0]].add(new edge(time[0], time[1], time[2]));
        }
        int result = dijkstras(graph, k);
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
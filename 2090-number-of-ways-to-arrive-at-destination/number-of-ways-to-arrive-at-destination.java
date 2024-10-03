class Pair{
    long dis;
    long node;
    public Pair(long dis,long node){
        this.dis=dis;
        this.node=node;
    }
}
class Solution {
    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<roads.length;i++){
            adj.get(roads[i][0]).add(new Pair(roads[i][2],roads[i][1]));
            adj.get(roads[i][1]).add(new Pair(roads[i][2],roads[i][0]));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y)->Long.compare(x.dis, y.dis));
        long dis[]=new long[n];
        long ways[]=new long[n];
        for(int i=0;i<n;i++){
            dis[i]=Long.MAX_VALUE;
            ways[i]=0;
        }
        pq.add(new Pair(0,0));
        dis[0]=0;
        ways[0]=1;
        int mod = (int) (1e9 + 7);
        while(!pq.isEmpty()){
            long currDis=pq.peek().dis;
            int node=(int)(pq.peek().node);
            pq.remove();
            for(Pair it: adj.get(node)){
                int adjNode = (int)it.node;
                long edgeWeight = it.dis;
                if(currDis+edgeWeight<dis[adjNode]){
                    dis[adjNode]=currDis+edgeWeight;
                    ways[adjNode]=ways[node];
                    pq.add(new Pair(currDis+edgeWeight,adjNode));
                }else if(currDis+edgeWeight==dis[adjNode]){
                    ways[adjNode]= (ways[adjNode]+ways[node])%mod;
                }
            }
        }
        return (int)(ways[n-1]%mod);
    }
}
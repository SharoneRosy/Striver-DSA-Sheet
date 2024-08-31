class Pair{
    int val;
    double prob;
    Pair(int val,double prob){
        this.val=val;
        this.prob=prob;
    }
}

class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        double [] res=new double[n];
        List<List<Pair>>adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(new Pair(edges[i][1],succProb[i]));
            adj.get(edges[i][1]).add(new Pair(edges[i][0],succProb[i]));
        }
        boolean vis[]=new boolean[n];
        PriorityQueue<Pair>pq=new PriorityQueue<>((a,b)->{return (b.prob>a.prob)?1:-1;});
        pq.add(new Pair(start_node,1.0));
        res[start_node]=1.0;
        while(!pq.isEmpty()){
            Pair curr=pq.poll();
            if(vis[curr.val] && res[curr.val]>curr.prob) continue;
            vis[curr.val]=true;
            for(Pair node :adj.get(curr.val)){
                if(res[node.val]<(res[curr.val]*node.prob)){
                    res[node.val]=res[curr.val]*node.prob;
                    pq.add(node);
                }
            }
        }
        return res[end_node];
    }
}
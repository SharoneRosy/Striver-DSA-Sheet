class Solution {
    int timer=1;
    private void dfs(int node,int parent,ArrayList<ArrayList<Integer>>adj,int []vis,int []low,int []time,List<List<Integer>>ans){
        vis[node]=1;
        time[node]=low[node]=timer;
        timer++;
        for(int neg:adj.get(node)){
            if(neg==parent) continue;
            if(vis[neg]==0){
                dfs(neg,node,adj,vis,low,time,ans);
                if(time[node]<low[neg]){
                    ans.add(Arrays.asList(node,neg));
                }
            }
            low[node]=Math.min(low[neg],low[node]);
        }
    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(List<Integer>edge:connections){
            int u=edge.get(0);
            int v=edge.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        List<List<Integer>>ans=new ArrayList<>();
        int []vis=new int[n];
        int []low=new int[n];
        int []time=new int[n];
        dfs(0,-1,adj,vis,low,time,ans);
        return ans;
    }
}
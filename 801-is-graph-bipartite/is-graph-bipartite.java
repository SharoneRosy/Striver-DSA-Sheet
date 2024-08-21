class Solution {
    public boolean dfs(int node,int [][]graph,int []col, int c){
        col[node]=c;
        for(int adjnode:graph[node]){
            if(col[node]==col[adjnode]){
                return false;
            }else  if(col[adjnode]==-1 && !dfs(adjnode,graph,col,1-c)){
                return false;
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int c=0;
        int []col=new int[n];
        Arrays.fill(col,-1);
        for(int i=0;i<n;i++){
            if(col[i]==-1){
                if(!dfs(i,graph,col,c)) return false;
            }
        }
        return true;
    }
}
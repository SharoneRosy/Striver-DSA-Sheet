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
                Queue<Integer>q=new LinkedList<>();
                q.add(i);
                while(!q.isEmpty()){
                    int node=q.poll();
                    int arr[]=graph[node];
                    for(int j=0;j<arr.length;j++){
                        int val=graph[node][j];
                        if (col[val]==-1){
                            col[val]=1-col[node];
                            q.add(val);
                        }else if(col[val]==col[node]){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
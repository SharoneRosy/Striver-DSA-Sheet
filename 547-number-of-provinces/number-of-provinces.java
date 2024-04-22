class Solution {
    public static void dfs(int node,ArrayList<ArrayList<Integer>>al,boolean[] vis){
        vis[node]=true;
        for(Integer it:al.get(node)){
            if(!vis[it]){
                dfs(it,al,vis);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
       ArrayList<ArrayList<Integer>> al=new ArrayList<>();
       for(int i=0;i<isConnected.length;i++){
        al.add(new ArrayList<>());
       }
       for(int i=0;i<isConnected.length;i++){
        for(int j=0;j<isConnected[0].length;j++){
            if(isConnected[i][j]==1 && i!=j){
                al.get(i).add(j);
                al.get(j).add(i);
            }
        }
       }
       int cnt=0;
    
       boolean [] vis=new boolean[isConnected[0].length];
       for(int i=0;i<isConnected[0].length;i++){
        if(!vis[i]){
            dfs(i,al,vis);
            cnt++;
        }
       }
       return cnt;
    }
}
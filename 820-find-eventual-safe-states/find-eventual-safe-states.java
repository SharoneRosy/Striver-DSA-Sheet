class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        ArrayList<ArrayList<Integer>> arr=new ArrayList<>();
        List<Integer> res=new ArrayList<>();
        for(int i=0;i<n;i++) arr.add(new ArrayList<>());
        Queue<Integer> q=new LinkedList<>();
        int in_degree[]=new int[n];
        for(int i=0;i<n;i++){
            for(int x:graph[i]){
                arr.get(x).add(i);
                in_degree[i]++;
            }
        }

        for(int i=0;i<n;i++){
            if(in_degree[i]==0){
                res.add(i);
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int u=q.poll();
            for(int v:arr.get(u)){
                in_degree[v]--;
                if(in_degree[v]<=0) {
                    q.add(v);
                    res.add(v);
                }
            }
        }
        Collections.sort(res);
        return res;
    }
}
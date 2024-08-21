class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
       

       List<List<Integer>>adj=new ArrayList<>();
       for(int i=0;i<numCourses;i++){
        adj.add(new ArrayList<>());
       }
       int [] indegree=new int[numCourses];
       for(int []row:prerequisites){
        adj.get(row[1]).add(row[0]);
        indegree[row[0]]++;
       }
       Queue<Integer>q=new LinkedList<>();
       for(int i=0;i<numCourses;i++){
        if(indegree[i]==0){
            q.add(i);
        }
       }

       Set<Integer>vis=new HashSet<>();
       while(!q.isEmpty()){
        int course=q.poll();
        vis.add(course);
        for(int adjnode:adj.get(course)){
            indegree[adjnode]--;
            if(indegree[adjnode]==0){
                q.add(adjnode);
            }
        }
       }
       return vis.size()==numCourses;
    }
}
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
       List<List<Integer>>adjList=new ArrayList<>();
       for(int i=0;i<numCourses;i++){
        adjList.add(new ArrayList<>());
       }
       int [] indegree=new int[numCourses];
       for(int []prerequisite: prerequisites){
            adjList.get(prerequisite[1]).add(prerequisite[0]);
            indegree[prerequisite[0]]++;
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
        for(int neg:adjList.get(course)){
            indegree[neg]--;
            if(indegree[neg]==0){
                q.add(neg);
            }
        }
       }
       return vis.size()==numCourses;
    }
}
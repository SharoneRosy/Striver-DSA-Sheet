class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        Map<Character,Integer>map=new HashMap<>();
        for(char task:tasks){
            map.put(task,map.getOrDefault(task,0)+1);
        }
        PriorityQueue<Integer>pq=new PriorityQueue<>(Collections.reverseOrder());
        pq.addAll(map.values());
        
        int time=0;
        while(!pq.isEmpty()){
            List<Integer>add_back=new ArrayList<>();
            for(int i=0;i<=n;i++){
                if(pq.size()>0){
                    int cnt=pq.poll();
                    cnt--;
                    if(cnt>0){
                    add_back.add(cnt);
                     }
                }
                time+=1;
                if(pq.size()==0 && add_back.size()==0) break;
            }
            pq.addAll(add_back);
        }
        return time;
    }
}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i:nums) map.put(i,map.getOrDefault(i,0)+1);
        PriorityQueue<int []>pq=new PriorityQueue<>((a,b)->a[1]-b[1]);
        for(int i:map.keySet()){
            pq.add(new int[]{i,map.get(i)});
            if(pq.size()>k){
                pq.poll();
            }
        }

        int []ans=new int[k];
        int j=0;
        while(!pq.isEmpty()){
            ans[j++]=pq.poll()[0];
        }
        return ans;
    }
}
class Solution {
    public int minGroups(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]==b[0]? a[1]-b[1]: a[0]-b[0]);
        PriorityQueue<Integer>pq=new PriorityQueue<>();
        for(int [] i:intervals){
            if(!pq.isEmpty() && i[0]>pq.peek()){
                pq.poll();
            }
            pq.add(i[1]);
        }
        return pq.size();
    }
}
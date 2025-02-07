public class Solution{
    public int minRefuelStops(int target,int startFuel,int [][] stations){
        int refuels=0,i=0,current=startFuel;
        PriorityQueue<Integer>maxHeap=new PriorityQueue<>(Collections.reverseOrder());
        while(current<target){
            while(i<stations.length && stations[i][0]<=current){
                maxHeap.add(stations[i++][1]);
            }
            if(maxHeap.isEmpty()) return -1;
            current+=maxHeap.poll();
            refuels++;
        }
        return refuels;
    }
}
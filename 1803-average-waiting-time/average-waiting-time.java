class Solution {
    public double averageWaitingTime(int[][] customers) {
        int idealtime=1;
        long totalwaitingtime=0;
        for(int[] customer:customers){
            if(idealtime<=customer[0]){
                  idealtime=customer[0]+customer[1];
            }else{
                idealtime=idealtime+customer[1];
            }
          totalwaitingtime+=(idealtime-customer[0]);
        }
        double avg=totalwaitingtime/(double)customers.length;
        return avg;
    }
}
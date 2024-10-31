class Solution {
    public long memo(int robIndex,int facIndex,List<Integer>robot,ArrayList<Integer>factorypos,long [][]dp ){
        if(robIndex>=robot.size()) return 0;
        if(facIndex>=factorypos.size()) return (long)1e12;
        if(dp[robIndex][facIndex]!=-1) return dp[robIndex][facIndex];

        long pick=Math.abs(robot.get(robIndex)-factorypos.get(facIndex))+memo(robIndex+1,facIndex+1,
                 robot,factorypos,dp);
        long notpick=memo(robIndex,facIndex+1,robot,factorypos,dp);
        return dp[robIndex][facIndex]=Math.min(pick,notpick);
    }
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory,(a,b)->a[0]-b[0]);
        ArrayList<Integer>factorypos=new ArrayList<>();
        for(int d[]:factory){
            for(int i=0;i<d[1];i++){
                factorypos.add(d[0]);
            }
        }

        int m=robot.size(),n=factorypos.size();
        long dp[][]=new long[m+1][n+1];
        for(long [] row:dp) Arrays.fill(row,-1);
        return memo(0,0,robot,factorypos,dp);
        }
}
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int n=intervals.length;
        int []start=new int[n];
        int []end=new int[n];
        for(int i=0;i<n;i++){
            start[i]=intervals[i][0];
            end[i]=intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int cnt=0;
        int i=0;
        int j=0;
        while(i<n){
            if(start[i]>=end[j]){
                cnt--;
                j++;
            }
             cnt++;
             i++;
        }
        return cnt;
    }
}
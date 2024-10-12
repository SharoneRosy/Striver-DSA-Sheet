class Solution {
    public int minGroups(int[][] intervals) {
        int n=intervals.length;
        int start[]=new int[n];
        int end[]=new int[n];
        for(int i=0;i<n;i++){
            start[i]=intervals[i][0];
            end[i]=intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int cnt=0;
        int max=Integer.MIN_VALUE;
        int i=0,j=0;
        while(i<n && j<n){
            if(start[i]<=end[j]){
                cnt++;
                i++;
            }else{
                cnt--;
                j++;
            }
           max=Math.max(cnt,max);
        }
        return max;
    }
}
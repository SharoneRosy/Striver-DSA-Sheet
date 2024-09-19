class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        int [] mergedInterval=intervals[0];
        List<int []>mergedIntervals=new ArrayList<>();
        for(int [] interval:intervals){
            if(interval[0]<=mergedInterval[1]){
                mergedInterval[1]=Math.max(interval[1],mergedInterval[1]);
            }else{
                mergedIntervals.add(mergedInterval);
                mergedInterval=interval;
            }
        }
        mergedIntervals.add(mergedInterval);
        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }
}
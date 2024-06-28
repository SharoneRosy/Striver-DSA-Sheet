class Solution {
    public long maximumImportance(int n, int[][] roads) {
        long edge[]=new long[n];
        long ans=0;
        for(int i=0;i<roads.length;++i){
            edge[roads[i][0]]++;
            edge[roads[i][1]]++;
        }
        Arrays.sort(edge);
        for(int i=n-1;i>=0;--i){
            ans+=((i+1)*edge[i]);
        }
        return ans;
    }
}
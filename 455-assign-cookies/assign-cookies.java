class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int m=g.length;
        int n=s.length;
        int cnt=0;
        int i=0,j=0;
        while(i<m && j<n){
            if(g[i]<=s[j]){
                cnt++;
                i++;
            }
            j++;
        }
        return cnt;
    }
}
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int ans=0;
        int j=0;
        Arrays.sort(g);
        Arrays.sort(s);
        for(int i:g){
            while(j<s.length && s[j]<i){
                j++;
            }
            if(j==s.length){
                 return ans;
            }else{
                ans++;
                j++;
            }

        }
        return ans;
        }
}
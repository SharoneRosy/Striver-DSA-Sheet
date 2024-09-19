class Solution {
    public int characterReplacement(String s, int k) {
        int [] count=new int[26];
        int maxlen=0;
        int maxfreq=0;
        int l=0,r=0;
        int n=s.length();
        while(r<n){
            count[s.charAt(r)-'A']++;
            maxfreq=Math.max(maxfreq,count[s.charAt(r)-'A']);
            if(r-l+1-maxfreq>k){
                count[s.charAt(l)-'A']--;
                l++;
            }
            if(r-l+1-maxfreq<=k){
                 maxlen=Math.max(maxlen,r-l+1);
            }
            r++;
        }
        return maxlen;
    }
}
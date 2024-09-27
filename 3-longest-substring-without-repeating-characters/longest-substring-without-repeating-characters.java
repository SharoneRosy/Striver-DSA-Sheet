class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        int l=0,r=0;
        int maxlen=0;
        HashMap<Character,Integer>map=new HashMap<>();
        while(r<n){
            if(map.containsKey(s.charAt(r))){
                l=Math.max(l,map.get(s.charAt(r))+1);
            }
            maxlen=Math.max(maxlen,(r-l+1));
            map.put(s.charAt(r),r);
            r++;
        }
        return maxlen;
    }
}
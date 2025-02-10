class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l=0,r=0;
        int n=s.length();
        HashMap<Character,Integer>map=new HashMap<>();
        int maxlen=0;
        while(r<n){
            char ch=s.charAt(r);
            if(map.containsKey(ch)){
                l=Math.max(l,map.get(s.charAt(r))+1);
            }
            map.put(ch,r);
            maxlen=Math.max(maxlen,(r-l+1));
            r++;
        }
        return maxlen;
    }
}
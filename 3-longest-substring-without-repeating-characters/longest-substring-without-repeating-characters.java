class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l=0,r=0;
        int n=s.length();
        int max=0;
        HashMap<Character,Integer>map=new HashMap<>();
        while(r<n){
            if(map.containsKey(s.charAt(r))){
                l=Math.max(map.get(s.charAt(r))+1,l);
            }
            map.put(s.charAt(r),r);
            max=Math.max(max,r-l+1);
            r++;
        }
        return max;
    }
}
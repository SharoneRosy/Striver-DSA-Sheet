class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int n=s.length();
        int max=0;
        int left=0;
        int right=0;
        Map<Character,Integer>map=new HashMap<>();
        while(right<n){
            map.put(s.charAt(right),map.getOrDefault(s.charAt(right),0)+1);
            while(map.size()>k){
                map.put(s.charAt(left),map.get(s.charAt(left))-1);
                if(map.get(s.charAt(left))==0){
                    map.remove(s.charAt(left));
                }
                left++;
            }
            max=Math.max(max,right-left+1);
            right++;
        }
        return max;
    }
}
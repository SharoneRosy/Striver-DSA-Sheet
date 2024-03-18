class Solution {
    public int lengthOfLongestSubstring(String s) {
        int []count=new int[256];
        int first=0,second=0,len=0;
        while(second<s.length()){
            while(count[s.charAt(second)]==1){
                count[s.charAt(first)]=0;
                first++;
            }
            count[s.charAt(second)]++;
            len=Math.max(len,(second-first+1));
            second++;
        }
        return len;
        
    }
}
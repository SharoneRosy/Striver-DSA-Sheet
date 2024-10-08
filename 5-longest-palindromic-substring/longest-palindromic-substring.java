class Solution {
    public String longestPalindrome(String s) {
        int start=0,end=0;
        for(int i=0;i<s.length()-1;i++){
            int len1=pal(s,i,i);
            int len2=pal(s,i,i+1);
            int len=Math.max(len1,len2);
            if(end-start<len){
                start=i-(len-1)/2;
                end=i+len/2;
            }
        }
        return s.substring(start,end+1);
    }
    public int pal(String s,int i,int j){
        if(s.charAt(i)!=s.charAt(j)) return 0;
        while(i>=0 && j<s.length() && s.charAt(i)==s.charAt(j)){
            i--;
            j++;
        }
        return j-i-1;
    }
}
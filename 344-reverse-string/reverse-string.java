class Solution {
    public void reverse(char[] st, int s,int e){
    if(s>e) return ;
    if(s<=e){
        char temp=st[s];
        st[s]=st[e];
        st[e]=temp;
    }
    reverse(st,s+1,e-1);
        }
    public void reverseString(char[] s) {
        int n=s.length;
        reverse(s,0,n-1);
    }
}
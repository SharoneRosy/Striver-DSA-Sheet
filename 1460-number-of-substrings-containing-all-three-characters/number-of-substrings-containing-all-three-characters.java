class Solution {
    public int numberOfSubstrings(String s) {
        int i=0;
        int j=0;
        int cnt=0;
        int []l= new int [3];
        int n=s.length();
        while(j<n){
            l[s.charAt(j)-'a']++;

            while(l[0]>0 && l[1]>0 && l[2]>0 && i<j){
                l[s.charAt(i)-'a']--;
                i++;
                cnt+=(n-j);
            }

            j++;
        }
        return cnt;
        
    }
}
class Solution {
    static boolean solve(String s,int i){
        int n=s.length();
        if(i>=n/2) return true;
        if(s.charAt(i)!=s.charAt(n-i-1)) return false;
        return solve(s,i+1);
    }
    public boolean isPalindrome(String s) {
        s=s.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
        if(s.length()<1) return true;
        int i=0;
        return solve(s,i);
        
    }
}
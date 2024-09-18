class Solution {
    public boolean isPalindrome(int x) {
        if(x<0 || x!=0 && x%10==0) return false;
        int rev=0;
        int n=x;
        while(n!=0){
            int rem=n%10;
            rev=rev*10+rem;
            n=n/10;
        } 
        return (x==rev);
    }
}
class Solution {
    public int reverse(int x) {
        int n=Math.abs(x);
        
        int rev=0;
        while(n!=0){
            int rem=n%10;
            
            if(rev>(Integer.MAX_VALUE-rem) /10)return 0;
            rev=rev*10+rem;
            n=n/10;
        }
        return (x<0)?(-rev):rev;
        
    }
}
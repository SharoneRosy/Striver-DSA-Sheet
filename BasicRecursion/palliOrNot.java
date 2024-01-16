package BasicRecursion;

public class palliOrNot {
    public static boolean check(String str,int s,int n){
        if(s>=n){
            return true;
        } 
        if(str.charAt(s)!=str.charAt(n)){
           return false;
        }
        return check(str,s+1,n-1);
    }
    public static boolean isPalindrome(String str) {
        // Write your code here.
        int n=str.length();
        return check(str,0,n-1);
    }
}

class Solution {
    public int myAtoi(String s) {
        s=s.trim();
        if(s.isEmpty()) {
            return 0;
        }
        int ans=0;
        int i=0;
    
        boolean neg=s.charAt(0)=='-';
        boolean pos=s.charAt(0)=='+';
        if(neg || pos){
            i++;
        }
        while(i<s.length()   && Character.isDigit(s.charAt(i))){
            int dig=s.charAt(i)-'0';
            if(ans>Integer.MAX_VALUE/10 || (ans==Integer.MAX_VALUE/10 && dig>Integer.MAX_VALUE%10)){
                return neg?Integer.MIN_VALUE:Integer.MAX_VALUE;
            }
            ans=ans*10+dig;
            i++;
        }
        return neg?-ans:ans;
    }
}
class Solution {
    public int myAtoi(String s) {
        

        // s=s.trim();
        // if(s.isEmpty()) return 0;
        // int ans=0;
        // int i=0;
        //  int max=Integer.MAX_VALUE;
        //  int min=Integer.MIN_VALUE;

        // boolean neg=s.charAt(0)=='-';
        // boolean pos=s.charAt(0)=='+';
        // if(neg|| pos){
        //     i++;
        // }
        // while(i<s.length() &&  Character.isDigit(s.charAt(i))){
        //     int digit = s.charAt(i)-'0';
        //         if(ans>max/10 || (ans==max/10 && digit>max%10)){
        //          return neg ? max : min;            
        //      }
        //     ans=ans*10+digit;
        //     i++;
        // }
        // return neg?-ans:ans;

         s = s.strip();
        if (s.isEmpty()) return 0;
        final int sign = s.charAt(0) == '-' ? -1 : 1;
        
        if (s.charAt(0) == '+' || s.charAt(0) == '-')
            s = s.substring(1);
        int startIdx = 0;
        int endIdx = 0;
        long ans = 0;
        ans = helper(s,startIdx,endIdx, ans, sign);
        System.out.println(sign + " " + ans);
        if (ans <= Integer.MIN_VALUE) return sign * (int) ans ;
        if (ans >= Integer.MAX_VALUE) return sign * (int) ans ; 
        return sign * (int)ans; 
    }
     public long helper(String in,int startIdx, int endIdx, long ans, int sign){
        if(endIdx == in.length() || in.charAt(endIdx) - '0' > 9) return ans;

        int startDig = in.charAt(startIdx) - '0';
        if(startDig < 0 && startDig > 9) return helper(in, startIdx++, endIdx++, ans, sign);

        int endDig = in.charAt(endIdx) - '0';
        if(endDig >= 0 && endDig <= 9) {
            ans = ans * 10;
            ans += endDig;
            if (sign * ans <= Integer.MIN_VALUE) return Integer.MIN_VALUE ;
            if (sign * ans >= Integer.MAX_VALUE) return Integer.MAX_VALUE ;
            return helper(in, startIdx, ++endIdx, ans, sign);
        }
        return ans;
    }
}
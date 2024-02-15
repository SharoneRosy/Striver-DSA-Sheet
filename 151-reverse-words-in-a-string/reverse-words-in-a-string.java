class Solution {
   

    public String reverseWords(String s) {
        s=s.trim();
        s=' '+s;
        int n=s.length();

        
        String ans="";
        for(int i=n-1;i>=0;i--){
            if(s.charAt(i)==' '){
                int j=i+1;
                while(j<n && s.charAt(j)!=' '){
                    ans+=s.charAt(j);
                    j++;
                }
                if(i!=0) ans+=' ';
                while(i>=0 && s.charAt(i)==' ')
                i--;
            }

            
        }return ans;
    }
}
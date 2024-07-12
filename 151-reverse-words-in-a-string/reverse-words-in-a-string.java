class Solution {
    public String reverseWords(String s) {
        s=s.trim();
        Stack<String> st=new Stack<>();
        
        String[] words=s.split("\\s+");
        for(String str:words)
        {
             
            st.push(str);
        }
        
        StringBuilder sb=new StringBuilder();
        
        while(!st.isEmpty())
        {   
             
            sb.append(st.pop());
            sb.append(" ");
            
           
                   
       }
       String ans= sb.toString().trim();
return ans;
 
    }
}
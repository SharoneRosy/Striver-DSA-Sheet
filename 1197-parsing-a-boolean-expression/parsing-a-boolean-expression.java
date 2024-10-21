class Solution {
    public boolean parseBoolExpr(String expression) {
        int n=expression.length();
        Stack<Character> st=new Stack<>();
        for(int i=0; i<n; i++)
        {
            char c=expression.charAt(i);
            if(c==')')
            {
                HashSet<Character> hs=new HashSet<>();
                while(st.peek()!='(')
                {
                    hs.add(st.pop());
                }
                st.pop();
                char op=st.pop();
                char res;
                if(op=='!') res=hs.contains('t')?'f':'t';
                else if(op=='&') res=hs.contains('f')?'f':'t';
                else res=hs.contains('t')?'t':'f';
                st.push(res);
            }
            else if(c!=',') st.push(c);
        }
        return st.pop()=='t';
    }
}
class Solution {
    
    int ind=0;
    public StringBuilder f(char[] s,int[] index,StringBuilder sb){  
        if(index[0]>=s.length) return sb;
        if(s[index[0]]=='('){
            StringBuilder x=f(s,new int[] {index[0]+1},new StringBuilder());
            sb.append(x);
            index[0]=ind;
        }
        else if(s[index[0]]==')'){
            ind=index[0];
            return sb.reverse();
        }
        else
            sb.append(s[index[0]]);
        return f(s,new int[] {index[0]+1},sb);
        
    }
    public String reverseParentheses(String s) {
        char[] sb=s.toCharArray();
        int[] index={0};
        return new String(f(sb,index,new StringBuilder()));
    }
}
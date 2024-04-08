class Solution {
    public String removeOuterParentheses(String s) {
        int opened=0;
        StringBuilder sb=new StringBuilder();
        for(char c:s.toCharArray()){
            if(c=='(' && opened++>0 ) sb.append(c);
            if(c==')' && opened-->1)  sb.append(c);
        }
        return sb.toString();
    }
}
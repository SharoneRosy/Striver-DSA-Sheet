class Solution {
    public String makeFancyString(String s) {
        int c=1;
        StringBuilder st= new StringBuilder();
        st.append(s.charAt(0));
        for(int i=1; i<s.length(); i++){
            if(s.charAt(i)==s.charAt(i-1)){
                c+=1;
            }
            else c=1;
            if(c<3) st.append(s.charAt(i));
        }
        return st.toString();
    }
}
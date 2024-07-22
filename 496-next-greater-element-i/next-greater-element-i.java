class Solution {
    public int[] nextGreaterElement(int[] num1, int[] num2) {
        int [] res=new int[num1.length];
        Stack<Integer>st=new Stack<>();
        Map<Integer,Integer>map=new HashMap<>();
        for(int i:num2){
            while(!st.isEmpty() && i>st.peek()){
                map.put(st.pop(),i);
            }
            st.push(i);
        }

        int i=0;
        for(int num:num1){
            res[i++]=map.getOrDefault(num,-1);
        }
        return res;
    }
}
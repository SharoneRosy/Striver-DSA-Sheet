class Solution {
    public int[] nextGreaterElement(int[] num1, int[] num2) {
        int [] ans=new int[num1.length];
        Stack<Integer>st=new Stack<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int num : num2){
            while(!st.isEmpty() && num>st.peek()){
                map.put(st.pop(),num);
            }st.add(num);
        }
        int i=0;
        for(int num:num1){
            ans[i++]=map.getOrDefault(num,-1);
        }
        return ans;
    }
}
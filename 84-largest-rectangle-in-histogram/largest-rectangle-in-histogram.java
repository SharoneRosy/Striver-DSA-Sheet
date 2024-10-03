class Solution {
    public int largestRectangleArea(int[] heights) {

        int maxi=0;
        Stack<Integer>st=new Stack<>();
        for(int i=0;i<=heights.length;i++){
            while(!st.isEmpty() && (i==heights.length || heights[st.peek()]>heights[i])){
                int len=heights[st.pop()];
                int width=st.isEmpty()?i:i-st.peek()-1;
                maxi=Math.max(maxi,len*width);
            }
            st.push(i);
        }
        return maxi;
    }
}
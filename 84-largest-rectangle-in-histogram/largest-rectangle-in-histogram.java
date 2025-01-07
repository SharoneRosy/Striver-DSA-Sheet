class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxi=0;
        Stack<Integer>st=new Stack<>();
        int n=heights.length;
        for(int i=0;i<=n;i++){
            while(!st.isEmpty() && (i==n || heights[st.peek()]>heights[i])){
                int len=heights[st.pop()];
                int wid=st.isEmpty()?i:i-st.peek()-1;
                maxi=Math.max(maxi,len*wid);
            }
            st.push(i);
        }
        return maxi;
    }
}
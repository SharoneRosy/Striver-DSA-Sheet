class Solution {
   public int maximalRectangle(char[][] matrix) {
    if (matrix.length == 0)
      return 0;

    int ans = 0;
    int[] answer = new int[matrix[0].length];

    for (char[] row : matrix) {
      for (int i = 0; i < row.length; ++i)
        answer[i] = row[i] == '0' ? 0 : answer[i] + 1;
      ans = Math.max(ans, largestRectangleArea(answer));
    }

    return ans;
  }
    // Prerequisite for this question------> Largest Histogram Area 
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
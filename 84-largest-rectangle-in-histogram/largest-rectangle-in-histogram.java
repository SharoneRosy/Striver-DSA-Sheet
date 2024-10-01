class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length, maxArea = 0;
        int[] previousSmaller = new int[n];
        int[] nextSmaller = new int[n];
        Stack<Integer> st = new Stack<>();

        // Compute Previous Smaller Element (PSE) array
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && heights[i] <= heights[st.peek()]) {
                st.pop();
            }
            previousSmaller[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        // Clear the stack to reuse it for NSE
        st.clear();

        // Compute Next Smaller Element (NSE) array
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && heights[i] <= heights[st.peek()]) {
                st.pop();
            }
            nextSmaller[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        // Calculate the maximum area
        for (int i = 0; i < n; i++) {
            int width = nextSmaller[i] - previousSmaller[i] - 1;
            maxArea = Math.max(maxArea, width * heights[i]);
        }

        return maxArea;
    }
}
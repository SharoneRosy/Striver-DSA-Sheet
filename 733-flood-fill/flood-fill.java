class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        int prevClr = image[sr][sc];
        if (prevClr == color) return image;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr, sc});
        image[sr][sc] = color;

        int drow[] = {0, -1, 0, 1};
        int dcol[] = {-1, 0, 1, 0};

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int row = curr[0];
            int col = curr[1];
            for (int k = 0; k < 4; k++) {
                int nrow = row + drow[k];
                int ncol = col + dcol[k];
                if (nrow >= 0 && ncol >= 0 && nrow < n && ncol < m && image[nrow][ncol] == prevClr) {
                    image[nrow][ncol] = color;
                    q.add(new int[]{nrow, ncol});
                }
            }
        }
        return image;
    }
}

class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int r = A.length;
        int c = A[0].length;
        int n = B[0].length;
        
        // Product matrix will have 'r x n' size.
        int[][] C = new int[r][n];
        
        for (int i = 0; i < r; ++i) {
            for (int k = 0; k < c; ++k) {
                // If current element of A is non-zero then iterate over all columns of B.
                if (A[i][k] != 0)  {
                    for (int j = 0; j < n; ++j) {
                        C[i][j] += A[i][k] * B[k][j];
                    }
                }
            }
        }
        
        return C;
    }
}
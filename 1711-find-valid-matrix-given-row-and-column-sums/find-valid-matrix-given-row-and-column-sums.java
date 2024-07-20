class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int rowCount = rowSum.length;
        int colCount = colSum.length;
        int[] currentRowSums = new int[rowCount];
        int[] currentColSums = new int[colCount];
        int[][] resultMatrix = new int[rowCount][colCount];

        for (int row = 0; row < rowCount; row++) {
            for (int col = 0; col < colCount; col++) {
                int rowRemaining = rowSum[row] - currentRowSums[row];
                int colRemaining = colSum[col] - currentColSums[col];
                resultMatrix[row][col] = Math.min(rowRemaining, colRemaining);
                
                currentRowSums[row] += resultMatrix[row][col];
                currentColSums[col] += resultMatrix[row][col];
            }
        }
        
        return resultMatrix;
    }
}
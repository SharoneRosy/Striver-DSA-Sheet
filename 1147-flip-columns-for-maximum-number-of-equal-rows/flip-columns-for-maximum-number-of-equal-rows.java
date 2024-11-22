class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int[] row : matrix) {
            StringBuilder pattern = new StringBuilder();
            for(int j = 0; j < row.length; j++) {
                pattern.append(row[0] == row[j] ? "T" : "F");
            }
            map.put(pattern.toString(), map.getOrDefault(pattern.toString(), 0) + 1);
        }

        return map.values().stream().max(Integer::compare).orElse(0);
    }
}
class Solution {
    private final int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    public int numDistinctIslands2(int[][] grid) {
        Set<Map<Integer, Integer>> distinctIslands = new HashSet<>();
        int rows = grid.length, cols = grid[0].length;
        
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    List<int[]> positions = new ArrayList<>();
                    exploreIsland(grid, r, c, positions);
                    
                    Map<Integer, Integer> distanceCount = new HashMap<>();
                    for (int i = 0; i < positions.size(); i++) {
                        for (int j = i + 1; j < positions.size(); j++) {
                            int dist = (int) Math.pow(positions.get(i)[0] - positions.get(j)[0], 2) +
                                       (int) Math.pow(positions.get(i)[1] - positions.get(j)[1], 2);
                            distanceCount.put(dist, distanceCount.getOrDefault(dist, 0) + 1);
                        }
                    }
                    distinctIslands.add(distanceCount);
                }
            }
        }
        return distinctIslands.size();
    }

    private void exploreIsland(int[][] grid, int r, int c, List<int[]> positions) {
        positions.add(new int[]{r, c});
        grid[r][c] = 0;
        
        for (int[] dir : dirs) {
            int rNext = r + dir[0], cNext = c + dir[1];
            if (rNext >= 0 && rNext < grid.length && cNext >= 0 && cNext < grid[0].length && grid[rNext][cNext] == 1) {
                exploreIsland(grid, rNext, cNext, positions);
            }
        }
    }
}

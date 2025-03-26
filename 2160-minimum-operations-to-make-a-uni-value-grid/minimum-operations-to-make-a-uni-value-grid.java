class Solution {
    public int minOperations(int[][] grid, int x) 
    {
        List<Integer> grids = new ArrayList<Integer>(); 
		int mod = grid[0][0]%x;
		
		for(int i=0;i<grid.length;i++)
		{
			for(int j=0;j<grid[i].length;j++)
			{
				if(grid[i][j] % x != mod) return -1;
				grids.add(grid[i][j]);
			}
		}
		
		Collections.sort(grids);
		
		int n = grids.size();
		
		int median = n/2;
		
		int steps = 0;
		
		for(int i=0;i<n;i++)
		{
			steps+= Math.abs(grids.get(i) - grids.get(median)) / x;
		}
		
		return steps;        
    }
}
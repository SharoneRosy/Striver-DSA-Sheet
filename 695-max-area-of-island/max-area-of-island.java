class Solution {
    public int dfs(int [][]grid,int i,int j,int m,int n){
        int cnt=1;
        grid[i][j]=0;
        int dr[]={-1,0,1,0};
        int dc[]={0,1,0,-1};
        for(int k=0;k<4;k++){
            int nrow=i+dr[k];
            int ncol=j+dc[k];
            if(nrow>=0 && ncol>=0 && nrow<m && ncol<n && grid[nrow][ncol]==1){
                cnt+=dfs(grid,nrow,ncol,m,n);
            }
        }
        return cnt;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int max=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    max=Math.max(max,dfs(grid,i,j,m,n));
                }
            }
        }
        return max;
    }
}
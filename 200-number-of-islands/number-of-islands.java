class Solution {
    public void dfs(char[][]grid, int row,int col){
        grid[row][col]='0';
        int[] drow={0,-1,0,1};
        int[] dcol={-1,0,1,0};
        for(int i=0;i<4;i++){
            int nrow=row+drow[i];
            int ncol=col+dcol[i];
            if(nrow>=0 && ncol>=0 && nrow<grid.length && ncol<grid[0].length && grid[nrow][ncol]=='1'){
                dfs(grid,nrow,ncol);
            }
        }
    }
    public int numIslands(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int cnt=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    cnt++;
                     dfs(grid,i,j);
                    //bfs(grid,i,j);
                }
            }
        }
        return cnt;
    }
    public void bfs(char[][] grid ,int row,int col){
        Queue<int []>q=new LinkedList<>();
        q.add(new int[]{row,col});
        int[] drow={0,-1,0,1};
        int[] dcol={-1,0,1,0};
        grid[row][col]='0';
        while(!q.isEmpty()){
            int []curr=q.poll();
            for(int i=0;i<4;i++){
            int nrow=curr[0]+drow[i];
            int ncol=curr[1]+dcol[i];
            if(nrow>=0 && ncol>=0 && nrow<grid.length && ncol<grid[0].length && grid[nrow][ncol]=='1'){
                q.add(new int[]{nrow,ncol});
                grid[nrow][col]='0';
            }
        }
        }
       
    }
}
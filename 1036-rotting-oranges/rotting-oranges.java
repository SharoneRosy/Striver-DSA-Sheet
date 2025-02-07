class Solution {
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int fresh=0;
        Queue<int []>q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                }else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        int []dr={-1,0,1,0};
        int []dc={0,1,0,-1};
        int time=0;
        while(!q.isEmpty() && fresh>0){
            int size=q.size();
            for(int i=0;i<size;i++){
                int curr[]=q.poll();
                int r=curr[0];
                int c=curr[1];
                for(int k=0;k<4;k++){
                    int nrow=r+dr[k];
                    int ncol=c+dc[k];
                    if(nrow>=0 && ncol>=0 && nrow<n && ncol<m && grid[nrow][ncol]==1){
                        grid[nrow][ncol]=2;
                        fresh--;
                        q.add(new int[]{nrow,ncol});
                    }
                }
            }
            time++;
        }
        return fresh==0?time:-1;
    }
}
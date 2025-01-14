class Solution {
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        Queue<int []>q=new LinkedList<>();
        int freshcnt=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                }
                if(grid[i][j]==1){
                    freshcnt++;
                }
            }
        }

        int time=0;
        int maderotten=0;
        int drow[]={0,-1,0,1};
        int dcol[]={-1,0,1,0};
        while(!q.isEmpty() && freshcnt>0){
            time++;
            int size=q.size();
            for(int i=0;i<size;i++){
                int []curr=q.poll();
                int x=curr[0];
                int y=curr[1];
                for(int k=0;k<4;k++){
                    int nrow=x+drow[k];
                    int ncol=y+dcol[k];
                    if(nrow>=0 && ncol>=0 && nrow<n && ncol<m && grid[nrow][ncol]==1){
                        grid[nrow][ncol]=2;
                        q.add(new int[]{nrow,ncol});
                        freshcnt--;
                    }
                }
            }
        }
        return freshcnt==0?time:-1;
    }
}
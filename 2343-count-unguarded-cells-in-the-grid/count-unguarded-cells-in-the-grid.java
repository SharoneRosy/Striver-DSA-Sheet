class Solution {
    int [][] vis;
    int [][] dir={{1,0},{0,1},{-1,0},{0,-1}};
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        vis=new int[m][n];
        Queue<int []>q=new LinkedList<>();
        for(int [] wall:walls){
            vis[wall[0]][wall[1]]=2;
        }
        for(int []guard:guards){
            vis[guard[0]][guard[1]]=1;
            q.add(new int[]{guard[0],guard[1]});
        }
        while(!q.isEmpty()){
            int [] curr=q.poll();
            for(int i=0;i<4;i++){
                int nrow=curr[0]+dir[i][0];
                int ncol=curr[1]+dir[i][1];
                while(nrow<m && nrow>-1 && ncol<n && ncol>-1 && vis[nrow][ncol]!=1 && vis[nrow][ncol]!=2)           {
                    vis[nrow][ncol]=-1;
                    nrow+=dir[i][0];
                    ncol+=dir[i][1];
                }
            }
        }
        int cnt=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(vis[i][j]==0) cnt++;
            }
        }
        return cnt;
    }
}
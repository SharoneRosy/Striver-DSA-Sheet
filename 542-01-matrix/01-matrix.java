class Pair
{
  int row;
  int col;
  int step;
  Pair(int r,int c,int s)
  {
      this.row=r;
      this.col=c;
      this.step=s;
  }
}
class Solution 
{
    public int[][] updateMatrix(int[][] mat) 
    {
        int n=mat.length;
        int m=mat[0].length;
        boolean vis[][]=new boolean[n][m];
        Queue<Pair>q=new LinkedList<>();
        int ans[][]=new int[n][m];
        for(int i=0;i<n;i++)
        {
          for(int j=0;j<m;j++)
          {
              if(mat[i][j]==0)
              {
                  q.add(new Pair(i,j,0));
                  vis[i][j]=true;
              }
          }
        }
        int delrow[]={-1,0,1,0};
        int delcol[]={0,1,0,-1};
        while(!q.isEmpty())
        {
            int r=q.peek().row;
            int c=q.peek().col;
            int s=q.peek().step;
            ans[r][c]=s;
            q.poll();
           for(int i=0;i<4;i++)
           {
            int nrow=r+delrow[i];
            int ncol=c+delcol[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==false)
             {
                 vis[nrow][ncol]=true;
                 q.add(new Pair(nrow,ncol,s+1));
             }
            }
        }
        return ans;
    }
}

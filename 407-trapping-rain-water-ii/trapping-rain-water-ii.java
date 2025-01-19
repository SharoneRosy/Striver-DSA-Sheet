class Solution {
     public class Tuple{
            int row;
            int col;
            int height;

            public Tuple(int row,int col,int height){
                this.row=row;
                this.col=col;
                this.height=height;
            }
        
        }
    public int trapRainWater(int[][] heightMap) {
        int m=heightMap.length;
        int n=heightMap[0].length;
  
        PriorityQueue<Tuple> pq=new PriorityQueue<>((a, b) -> Integer.compare(a.height, b.height));
        boolean visited[][]=new boolean[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0||j==0|i==m-1||j==n-1){
                pq.add(new Tuple(i,j,heightMap[i][j]));
                visited[i][j]=true;
                }
            }
        }
        int [][]dirs={{0,1},{0,-1},{1,0},{-1,0}};
        int waterTrapped=0;

        while(pq.size()>0){
            Tuple cur=pq.remove();

            for(int dir[]:dirs){
                int nx=cur.row+dir[0];
                int ny=cur.col+dir[1];
                if(nx>=0 && nx<m && ny>=0 && ny<n &&
                visited[nx][ny]==false){
                  visited[nx][ny]=true;
                  if(cur.height>heightMap[nx][ny]){
                      waterTrapped+=cur.height-heightMap[nx][ny];
                       pq.add(new Tuple(nx,ny,cur.height));
                    
                  }else{
                       pq.add(new Tuple(nx,ny,heightMap[nx][ny]));
                  }
                  

                }
            }
        }
        return waterTrapped;
       
    }

    
}
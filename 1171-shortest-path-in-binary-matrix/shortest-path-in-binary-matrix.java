class Tuple { 
    int first, second, third; 
    Tuple(int _first, int _second, int _third) {
        this.first = _first; 
        this.second = _second; 
        this.third = _third; 
    }
}

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1){
            return -1;
        }
        if(grid.length == 1){
            return 1;
        }
        int[][] dist = new int[grid.length][grid[0].length]; 
        for(int i = 0;i<grid.length;i++) {
            for(int j =0;j<grid[0].length;j++) {
                dist[i][j] = (int)(1e9); 
            }
        }
        dist[0][0] = 1;

        Queue<Tuple> q = new LinkedList<>();
        int dx[] = {-1, 0, 1, 0,1,1,-1,-1}; 
        int dy[] = {0, 1, 0, -1,-1,1,-1,1}; 
        q.add(new Tuple(0,0,1));
        while(!q.isEmpty()){
            int x = q.peek().first;
            int y = q.peek().second;
            int wt = q.peek().third;
            q.poll();
            for(int i = 0;i<8;i++){
                int xx = x + dx[i];
                int yy = y + dy[i];

                if(xx>=0 && xx<grid.length && yy>=0 && yy<grid[0].length && grid[xx][yy] == 0 && wt + 1 < dist[xx][yy]){
                    dist[xx][yy] = wt+1;
                    if(xx == grid.length-1 && yy == grid[0].length-1){
                        return wt+1;
                    }
                    q.add(new Tuple(xx,yy,wt+1));
                }
            }
        }
        return -1;
    }
}
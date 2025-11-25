class Solution {
    int m,n;
    public boolean exist(char[][] b, String w) {
        m=b.length; n=b[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(dfs(b,w,0,i,j)) return true;
            }
        }
        return false;
    }
    boolean dfs(char[][] b,String w,int k,int i,int j){
        if(k==w.length()) return true;
        if(i<0||j<0||i>=m||j>=n||b[i][j]!=w.charAt(k)) return false;
        char t=b[i][j];
        b[i][j]='#';
        boolean r=dfs(b,w,k+1,i+1,j)||
                  dfs(b,w,k+1,i-1,j)||
                  dfs(b,w,k+1,i,j+1)||
                  dfs(b,w,k+1,i,j-1);
        b[i][j]=t;
        return r;
    }
}

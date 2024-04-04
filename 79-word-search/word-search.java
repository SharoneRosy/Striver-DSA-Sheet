class Solution {
    boolean visited[][];
    public boolean exist(char[][] board, String word) {
        int rows=board.length;
        int cols=board[0].length;
        visited=new boolean[rows][cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(word.charAt(0)==board[i][j] && solve(i,j,0,word,board)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean solve(int i,int j,int curr,String word,char[][] board){
        if(curr==word.length()){
            return true;
        }
        if(i<0|| i>=board.length || j<0 || j>=board[i].length || board[i][j]!=word.charAt(curr) || visited[i][j]){
            return false;
        }
        visited[i][j]=true;
        if(solve(i+1,j,curr+1,word,board) ||
            solve(i-1,j,curr+1,word,board) ||
            solve(i,j-1,curr+1,word,board) ||
            solve(i,j+1,curr+1,word,board)){
                return true;
            }
            visited[i][j]=false;
            return false;
    }
}
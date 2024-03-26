class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String>seen=new HashSet();
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                char currval=board[i][j];
                if(currval!='.'){
                    if(!seen.add(currval+"found in the row"+i) ||
                       !seen.add(currval+"found in the coloumn"+j) ||
                       !seen.add(currval+"found in the sub box"+i/3+"-"+j/3) 
                    )return false;
                }
            }
        }
        return true;
    }
}
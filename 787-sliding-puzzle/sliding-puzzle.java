class Solution {
    public int slidingPuzzle(int[][] board) {
        int [][] dir={
            {1,3},
            {0,2,4},
            {1,5},
            {0,4},
            {3,1,5},
            {4,2}
        };

        String target="123450";
        StringBuilder startstate=new StringBuilder();

        for(int [] row:board){
            for(int num:row){
                startstate.append(num);
            }
        }

        if(startstate.toString().equals(target)){
            return 0;
        }
        
        Set<String>vis=new HashSet<>();
        Queue<String>q=new LinkedList<>();
        q.add(startstate.toString());
        vis.add(startstate.toString());

        int moves=0;

        while(!q.isEmpty()){
            int size=q.size();
            while(size-->0){
                String currstate=q.poll();
                if(currstate.equals(target)){
                    return moves;
                }
                int zeropos=currstate.indexOf('0');
                for(int newpos:dir[zeropos]){
                    String nextState=swap(currstate,zeropos,newpos);
                    if(!vis.contains(nextState)){
                        vis.add(nextState);
                        q.add(nextState);
                    }
                }
            }
            moves++;
        }
        return -1;
    }

    private String swap(String str,int i,int j){
        StringBuilder sb=new StringBuilder(str);
        sb.setCharAt(i,str.charAt(j));
        sb.setCharAt(j,str.charAt(i));
        return sb.toString();
    }
}
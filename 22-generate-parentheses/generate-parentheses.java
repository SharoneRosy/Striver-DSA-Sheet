class Solution {
    public void solve(int c,int o,String s, int n, List<String>res){
        if(o==n && c==n){
            res.add(s);
            return ;
        }
        if(o<n){
            solve(c,o+1,s+"(",n,res);
        }
        if(c<o){
            solve(c+1,o,s+")",n,res);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String>res=new ArrayList<>();
        String s="";
        solve(0,0,s,n,res);
        return res;
    }
}
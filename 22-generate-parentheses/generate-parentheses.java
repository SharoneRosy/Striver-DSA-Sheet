class Solution {
    private void solve(int o,int c,String s, int n, List<String>res){
        if(o==n && c==n){
            res.add(s);
            return;
        }
        if(o<n){
            solve(o+1,c,s+"(",n,res);
        }
        if(c<o){
            solve(o,c+1,s+")",n,res);
        }
      }
    public List<String> generateParenthesis(int n) {
        List<String>res=new ArrayList<>();
        String s="";
        solve(0,0,s,n,res);
        return res;
    }
}
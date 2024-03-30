class Solution {
    public void solve(int no,int sum,int i,List<List<Integer>> res,List<Integer>l){
        if(no==0 && sum==0) {
            res.add(new ArrayList<>(l));
            return ;
        }
        if(no<0 || sum<0) return;
        if(i>9)  return;
        
        l.add(i);
        solve(no-1,sum-i,i+1,res,l);
        l.remove(l.size()-1);
        solve(no,sum,i+1,res,l);
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>>res=new ArrayList<>();
        List<Integer>l=new ArrayList<>();
        solve(k,n,1,res,l);
        return res;
    }
}
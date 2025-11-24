class Solution {
    public void solve(int [] nums,List<Integer>ls, List<List<Integer>>res,int i){
        if(i==nums.length){
            res.add(new ArrayList<>(ls));
            return ;
        }
        ls.add(nums[i]);
        solve(nums,ls,res,i+1);
        ls.remove(ls.size()-1);
        solve(nums,ls,res,i+1);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>>res=new ArrayList<>();
        List<Integer>ls=new ArrayList<>();
        solve(nums,ls,res,0);
        return res;
    }
}
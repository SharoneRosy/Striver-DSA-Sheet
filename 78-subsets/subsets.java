class Solution {
    public void solve(int i,int[] nums,List<Integer>l, List<List<Integer>>res){
        if(i==nums.length){
            res.add(new ArrayList<>(l));
            return;
        }
        l.add(nums[i]);
        solve(i+1,nums,l,res);
        l.remove(l.size()-1);
        solve(i+1,nums,l,res);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>>res=new ArrayList<>();
        List<Integer>l=new ArrayList<>();
        solve(0,nums,l,res);
        return res;
        
    }
}
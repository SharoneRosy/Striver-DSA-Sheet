class Solution {
    public void solve(int i,List<Integer>list,List<List<Integer>>res,int[] nums){
        if(i==nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[i]);
        solve(i+1,list,res,nums);
        list.remove(list.size()-1);
        solve(i+1,list,res,nums);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>>res=new ArrayList<>();
        List<Integer>list=new ArrayList<>();
        solve(0,list,res,nums);
        return res;
    }
}
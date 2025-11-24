class Solution {
    public void solve(int [] nums,List<Integer>ls, List<List<Integer>>res,int target,int ind){
        if(target==0){
            res.add(new ArrayList<>(ls));
        }
        for(int i=ind;i<nums.length;i++){
            if(i!=ind && nums[i]==nums[i-1]) continue;
            if(nums[i]<=target){
                ls.add(nums[i]);
                solve(nums,ls,res,target-nums[i],i+1);
                ls.remove(ls.size()-1);
            }
        }

    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>>res=new ArrayList<>();
        List<Integer>ls=new ArrayList<>();
        Arrays.sort(candidates);
        solve(candidates,ls,res,target,0);
        return res;
    }
}
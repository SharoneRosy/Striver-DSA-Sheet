class Solution {
    public void solve(int ind,int [] arr,int target,List<List<Integer>> ans,List<Integer>list){
        if(target==0){
            ans.add(new ArrayList<>(list));
            return ;
        }
        for(int i=ind;i<arr.length;i++){
            if(i>ind && arr[i]==arr[i-1]) continue;
            if(target<arr[i]) break;
            list.add(arr[i]);
            solve(i+1,arr,target-arr[i],ans,new ArrayList<>(list));
            list.remove(list.size()-1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(candidates);
        solve(0,candidates,target,ans,new ArrayList<>());
        return ans;
    }
}
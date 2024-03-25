class Solution {
    public void solve(int i,int[] arr, int target,List<List<Integer>>ans,List<Integer>list){
        if(i==arr.length){
            if(target==0){
                ans.add(new ArrayList<>(list));
            }
            return;
        }
        if(target>=arr[i]){
            list.add(arr[i]);
            solve(i,arr,target-arr[i],ans,new ArrayList<>(list));
            list.remove(list.size()-1);
        }
        solve(i+1,arr,target,ans,new ArrayList<>(list));
    }
    public List<List<Integer>> combinationSum(int[] arr, int target) {
        List<List<Integer>>ans=new ArrayList<>();
        solve(0,arr,target,ans,new ArrayList<>());
        return ans;
        
    }
}
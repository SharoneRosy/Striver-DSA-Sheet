class Solution {
    public void solve(int[] arr, int target,int ind,List<Integer>list,List<List<Integer>>ans){
        if(ind==arr.length){
            if(target==0){
                ans.add(new ArrayList<>(list));
            } return;
        }

        if(arr[ind]<=target){
            list.add(arr[ind]);
            solve(arr,target-arr[ind],ind,list,ans);
            list.remove(list.size()-1);
        }
        solve(arr,target,ind+1,list,ans);
    }
    public List<List<Integer>> combinationSum(int[] arr, int target) {
        List<List<Integer>>ans=new ArrayList<>();
        List<Integer>list=new ArrayList<>();
        solve(arr,target,0,list,ans);
        return ans;
    }
}
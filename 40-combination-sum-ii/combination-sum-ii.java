class Solution {
 
    public void solve(int ind,int [] arr, int target,List<List<Integer>>ans,List<Integer>list){
        if(target==0){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=ind;i<arr.length;i++){
            if(i>ind && arr[i]==arr[i-1]) continue;
            if(arr[i]>target) break;
            list.add(arr[i]);
            solve(i+1,arr,target-arr[i],ans,list);
            list.remove(list.size()-1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] arr, int target) {
       
        List<List<Integer>>ans=new ArrayList<>();
        List<Integer>list=new ArrayList<>();
        Arrays.sort(arr);
        solve(0,arr,target,ans,list);
        return ans;
    }
}
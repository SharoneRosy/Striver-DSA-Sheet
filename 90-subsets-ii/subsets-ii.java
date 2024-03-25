class Solution {
    public void solve(int ind,int[]  arr,List<List<Integer>>ans, List<Integer>list){
        ans.add(new ArrayList<>(list));
        for(int i=ind;i<arr.length;i++){
            if(i!=ind && arr[i]==arr[i-1]) continue;
            list.add(arr[i]);
            solve(i+1,arr,ans,list);
            list.remove(list.size()-1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>>ans=new ArrayList<>();
        solve(0,nums,ans,new ArrayList<>());
        return ans;
    }
}
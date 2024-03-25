class Solution {
    public void solve(int [] arr, List<List<Integer>>ans, List<Integer>ds,boolean [] map){
        if(ds.size()==arr.length){
            ans.add(new ArrayList<>(ds));
            return ;
        }
        for(int i=0;i<arr.length;i++){
            if(map[i]!=true){
                map[i]=true;
                ds.add(arr[i]);
                solve(arr,ans,ds,map);
                ds.remove(ds.size()-1);
                map[i]=false;
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>>ans=new ArrayList<>();
        List<Integer>ds=new ArrayList<>();
        boolean [] map=new boolean[nums.length];
        solve(nums,ans,ds,map);
        return ans;
    }
}
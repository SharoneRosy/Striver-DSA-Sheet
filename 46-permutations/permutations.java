class Solution {
    public void solve(int ind,int [] arr, List<List<Integer>>ans){
        if(ind==arr.length){
            List<Integer>ds=new ArrayList<>();
            for(int i=0;i<arr.length;i++){
                ds.add(arr[i]);
            }
            ans.add(new ArrayList<>(ds));
        }
        for(int i=ind;i<arr.length;i++){
            swap(i,ind,arr);
            solve(ind+1,arr,ans);
            swap(i,ind,arr);
        }

    }
    public void swap(int i,int j,int [] nums){
       int temp=nums[i];
       nums[i]=nums[j];
       nums[j]=temp;
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>>ans=new ArrayList<>(); 
        solve(0,nums,ans);
        return ans;
    }
}
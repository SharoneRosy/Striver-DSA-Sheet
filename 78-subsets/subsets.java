class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new ArrayList();
        int n=nums.length;
        for(int i=0;i<Math.pow(2,n);i++){
            List<Integer>curr=new ArrayList();
            for(int j=0;j<n;j++){
                if(((1<<j)&i)!=0)
                 curr.add(nums[j]);
            }
            res.add(curr);
        }
        return res;
    }
}
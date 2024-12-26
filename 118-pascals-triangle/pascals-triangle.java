

class Solution{
    public List<List<Integer>> generate(int n){
        List<List<Integer>>ans=new ArrayList<>();
        ans.add(new ArrayList<>());
        ans.get(0).add(1);
        for(int i=1;i<n;i++){
            List<Integer>row=new ArrayList<>();
            List<Integer>prow=ans.get(i-1);
            row.add(1);
            for(int j=1;j<i;j++){
                row.add(prow.get(j-1)+prow.get(j));
            }
            row.add(1);
            ans.add(row);
        }
        return ans;
    }
}
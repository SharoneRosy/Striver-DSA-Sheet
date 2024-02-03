class Solution {

    public static int nCr(int i,int j){
        int res=1;
        for(int a=0;a<j;a++){
            res=res*(i-a);
            res=res/(a+1);
        }
        return res;
    }
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            List<Integer> row=new ArrayList<>();
            for(int j=0;j<=i;j++){
                row.add(nCr(i,j));
            }
        
        ans.add(row);
    }
    return ans;
    }
}
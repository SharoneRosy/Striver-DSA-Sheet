class Solution {
    public List<List<Integer>> generate(int n) {
        List<List<Integer>>tri=new ArrayList<>();
        tri.add(new ArrayList<>());
        tri.get(0).add(1);
        for(int i=1;i<n;i++){
            List<Integer>row=new ArrayList<>();
            List<Integer>prow=tri.get(i-1);
            row.add(1);
            for(int j=1;j<i;j++){
                row.add(prow.get(j-1)+prow.get(j));
            }
            row.add(1);
            tri.add(row);
        }
        return tri;
    }
}
class Solution {
    public String getPermutation(int n, int k) {
        List<Integer>numbers=new ArrayList<>();
        String ans="";
        int fact=1;
        for(int i=1;i<n;i++){
            fact=i*fact;
            numbers.add(i);
        }
        numbers.add(n);
        k=k-1;
        while(true){
            ans+=numbers.get(k/fact);
            numbers.remove(k/fact);
            if(numbers.size()==0){
                break;
            }
            k=k%fact;
            fact=fact/numbers.size();
        }
        return ans;
    }
}
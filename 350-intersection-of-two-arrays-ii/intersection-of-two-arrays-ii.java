class Solution {
    public int[] intersect(int[] num1, int[] num2) {
        Arrays.sort(num1);
        Arrays.sort(num2);
        int i=0,j=0;
        List <Integer> intersection=new ArrayList<>();
        while(i<num1.length && j<num2.length){
            if(num1[i]<num2[j]){
                i++;
            }else if(num1[i]>num2[j]){
                j++;
            }else{
                intersection.add(num1[i]);
                i++;
                j++;
            }
        }
        int [] res=new int[intersection.size()];
        for(int k=0;k<intersection.size();k++){
            res[k]=intersection.get(k);
        }
        return res;
    }
}
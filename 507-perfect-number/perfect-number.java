class Solution {
    public boolean checkPerfectNumber(int num) {
        int res=0;
        if(num==1)return false;
        for(int i=1;i*i<=num;i++){
            if(num%i==0){
                res+=i+((i!=1 && i!=(num/i))?num/i:0);
            }
        }
        return res==num;
    }
}
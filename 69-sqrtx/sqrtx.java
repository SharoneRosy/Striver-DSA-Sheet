class Solution {
    public int mySqrt(int x) {
        int low=0,high=x;
        int res=0;
        while(low<=high){
            int mid=(low+high)/2;
            long seq=(long)mid*mid;
            if(seq>x){
                high=mid-1;
            }else if(seq<x){
                low=mid+1;
                res=mid;
            }else{
                return mid;
            }
        }
        return res;
    }
}
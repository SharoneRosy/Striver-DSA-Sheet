class Solution {
    public int trap(int[] height) {
        int l=0;
        int r=height.length-1;
        int lmax=height[l];
        int rmax=height[r];
        int res=0;
        while(l<r){
            if(lmax<=rmax){
                res+=lmax-height[l];
                l++;
                lmax=Math.max(lmax,height[l]);
            }else{
                res+=rmax-height[r];
                r--;
                rmax=Math.max(rmax,height[r]);
            }
        }
        return res;
    }
}
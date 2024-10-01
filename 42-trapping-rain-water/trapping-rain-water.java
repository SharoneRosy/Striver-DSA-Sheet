class Solution {
    public int trap(int[] height) {
        int i=0,j=height.length-1;
        int  leftmax=height[0],rightmax=height[j];
        int sum=0;
        while(i<j){
            if(leftmax<=rightmax){
                sum+=(leftmax-height[i]);
                i++;
                leftmax=Math.max(leftmax,height[i]);
            }else{
                sum+=(rightmax-height[j]);
                j--;
                rightmax=Math.max(rightmax,height[j]);
            }
        }
        return sum;
    }
}
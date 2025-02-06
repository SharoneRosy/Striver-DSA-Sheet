class Solution {
    public int trap(int[] height) {
        int sum=0;
        int i=0;
        int j=height.length-1;
        int leftmax=height[i];
        int rightmax=height[j];
        while(i<j){
            if(leftmax<=rightmax){
                sum+=leftmax-height[i];
                i++;
                leftmax=Math.max(leftmax,height[i]);
            }else{
                sum+=rightmax-height[j];
                  j--;
                rightmax=Math.max(rightmax,height[j]);
            }
        }
        return sum;
    }
}
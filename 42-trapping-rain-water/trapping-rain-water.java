class Solution {
    public int trap(int[] height) {
        int i=0;
        int j=height.length-1;
        int leftMax=height[0];
        int rightMax=height[height.length-1];
        int sum=0;
        while(i<j){
            if(leftMax<=rightMax){
                sum+=(leftMax-height[i]);
                i++;
                leftMax=Math.max(leftMax,height[i]);
            }else{
                sum+=(rightMax-height[j]);
                j--;
                rightMax=Math.max(rightMax,height[j]);
            }
        }
        return sum;
    }
}
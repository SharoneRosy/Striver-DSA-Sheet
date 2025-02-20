class Solution {
    public int trap(int[] height) {
     int sum=0;
     int n=height.length;
     int left=0,right=n-1;
     int leftmax=height[0],rightmax=height[n-1];
     while(left<right){
        if(leftmax<=rightmax){
            sum+=leftmax-height[left];
            left++;
            leftmax=Math.max(leftmax,height[left]);
        }else{
            sum+=rightmax-height[right];
            right--;
            rightmax=Math.max(rightmax,height[right]);
        }
     } 
     return sum;  
    }
}
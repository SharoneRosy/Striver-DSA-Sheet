package BasicArrays;

public class subarraysumkp {
    public static int longestSubarrayWithSumK(int []a, long k) {
        // Write your code here
        int left=0,right=0;
        int n=a.length;
        long sum=a[0];
        int max=0;
        while(n>right){
            while(left<=right && sum>k){
                sum-=a[left];
                left++;
            }
            if(sum==k){
                max=Math.max(max, right-left+1);
            }
            right++;
            if(right<n){
                sum+=a[right];
                
            }
        
        }return max;
    }
}

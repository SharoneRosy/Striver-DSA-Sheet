class Solution {
    public int f(int i,int n,int k,int[] arr,int [] dp){
        if(i==n) return 0;
        if(dp[i]!=-1) return dp[i];
        int len=0;
        int maxi=Integer.MIN_VALUE;
        int maxans=Integer.MIN_VALUE;
        for(int j=i;j<Math.min(n,i+k);j++){
            len++;
            maxi=Math.max(maxi,arr[j]);
            int sum=len*maxi+f(j+1,n,k,arr,dp);
            maxans=Math.max(maxans,sum);
        }
        return dp[i]=maxans;
    }
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n=arr.length;
        int dp[]=new int[n+1];
        Arrays.fill(dp,0);
        for(int i=n-1;i>=0;i--){
            int len=0;
        int maxi=Integer.MIN_VALUE;
        int maxans=Integer.MIN_VALUE;
            for(int j=i;j<Math.min(n,i+k);j++){
                len++;
                maxi=Math.max(maxi,arr[j]);
                int sum=len*maxi+dp[j+1];
                maxans=Math.max(maxans,sum);
            }
             dp[i]=maxans;
        }
        return  dp[0];
    }
}
class Solution {
    public int CalDays(int[] weights, int mid){
        int n=weights.length;
        int load=0;
        int days=1;
        for(int i=0;i<n;i++){
            if(load+weights[i]>mid){
                days+=1;
                load=weights[i];
            }else{
                load+=weights[i];
            }
        }return days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int n=weights.length;
        int maxi=Integer.MIN_VALUE;
          int sum=0;
        for(int i=0;i<n;i++){
            maxi=Math.max(maxi,weights[i]);
            sum+=weights[i];
        }
      

        int low=maxi,high=sum;
        while(low<=high){
            int mid=(low+high)/2;
            int noofdays=CalDays(weights,mid);
            if(noofdays<=days){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }return low;

    }
}
class Solution {
    public boolean possible(int[] bloomDay,int day,int m,int k){
        int noOfFlowers=0;
        int noOfBoqs=0;
        for(int i=0;i<bloomDay.length;i++){
            if(bloomDay[i]<=day){
                noOfFlowers++;
            }else{
                noOfBoqs+=(noOfFlowers/k);
                noOfFlowers=0;
            }
        }
        noOfBoqs+=(noOfFlowers/k);
        return noOfBoqs>=m;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int mini=Integer.MAX_VALUE;
        int maxi=Integer.MIN_VALUE;
        int n=bloomDay.length;
        long val=(long)k*m;
        if(val>n) return -1;
        for(int i=0;i<n;i++){
            mini=Math.min(mini,bloomDay[i]);
            maxi=Math.max(maxi,bloomDay[i]);
        }

        int low=mini;
        int high=maxi;
        while(low<=high){
            int mid=(low+high)/2;
            if(possible(bloomDay,mid,m,k)){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return low;
    }
}
class Solution {
    public int findMax(int[] piles){
        int n=piles.length;
        int maxi=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            maxi=Math.max(maxi,piles[i]);
        }return maxi;
    }

    public int totalhour(int[] piles,int h){
        int th=0;
        int n=piles.length;
        for(int i=0;i<n;i++){
            th+=Math.ceil((double)piles[i]/(double)(h));
        }return th;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int low=1,high=findMax(piles);
        while(low<=high){
            int mid=(low+high)/2;
            int totalhours=totalhour(piles, mid);
            if(totalhours<=h){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return low;
    }
}
class Solution {
    public long repairCars(int[] ranks, int cars) {
        int maxRank=Integer.MIN_VALUE;
        for(int i=0;i<ranks.length;i++)
        {
            maxRank=Math.max(maxRank,ranks[i]);
        }
        long max = (long) maxRank * cars * cars;

        return bs(1,max,ranks,cars);
    }

    public long bs(long l, long r, int[] ranks, int cars)
    {
        
        long mid=(l+r)/2;

        if(l>=r)
        {
            return mid;
        }
        
        if(valid(mid,ranks,cars)==true)
        {
            return bs(l,mid,ranks,cars);
        }
        else
        {
            return bs(mid+1,r,ranks,cars);
        }
    }

    public boolean valid(long T,int[] ranks, int cars)
    {
        long sum=0;
        for(int i=0;i<ranks.length;i++)
        {
            sum=sum+(long)Math.sqrt(T/ranks[i]);
        }
        if(sum>=cars)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
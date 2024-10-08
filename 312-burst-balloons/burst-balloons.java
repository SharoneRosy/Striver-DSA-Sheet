class Solution
 {
     public int find(int i,int j,List<Integer> l,int dp[][])
     {
         if(i>j)
           return 0;
           if(dp[i][j]!=-1)
            return dp[i][j];
            int min=Integer.MIN_VALUE;
        for(int k=i;k<=j;k++)
        {
            int burst=l.get(i-1)*l.get(k)*l.get(j+1)+find(i,k-1,l,dp)+find(k+1,j,l,dp);
            min=Math.max(min,burst);
        }
        return dp[i][j]=min;
     }
    public int maxCoins(int[] nums)
     {
         int n=nums.length;
         int dp[][]=new int[n+1][n+1];
         for(int i=0;i<=n;i++)
         {
             for(int j=0;j<=n;j++)
             {
                 dp[i][j]=-1;
             }
         }
         List<Integer> l=new ArrayList<>();
         for(int i:nums)
          l.add(i);
          l.add(1);
          l.add(0,1);
          

         return find(1,n,l,dp);
        
    }
}
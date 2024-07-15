class Solution {
    public int maxScore(int[] cardPoints, int k) 
    {
    
     int n=cardPoints.length;
     int ls=0,rs=0;
     int sum=0;
     int maxPoints=0;
     int right=0;
     for(int i=0;i<k;i++){
        ls+=cardPoints[i];
        maxPoints=ls;
     }
     right=n-1;
     for(int j=k-1;j>=0;j--){
        ls-=cardPoints[j];
        rs+=cardPoints[right];
        right--;
        maxPoints=Math.max(maxPoints,ls+rs);
     }
     return maxPoints;
}
}
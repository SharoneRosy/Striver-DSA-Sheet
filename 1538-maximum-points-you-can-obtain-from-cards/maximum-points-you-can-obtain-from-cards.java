class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int sumofk=0;
        
        int n=cardPoints.length;
        for(int i=0;i<k;i++){
            sumofk+=cardPoints[i];
        }
         int i=0;
         int maxsum=sumofk;
         while(i<k){
            sumofk=sumofk-cardPoints[k-i-1]+cardPoints[n-i-1];
            maxsum=Math.max(maxsum,sumofk);
            i++;
         }
         return maxsum;
        
    }
}
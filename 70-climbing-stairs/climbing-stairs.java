class Solution {
    public int climbStairs(int n) {
        int prev2=0, prev1=1,curr=0;
        for(int i=1;i<=n;i++){
            curr=prev2+prev1;
            prev2=prev1;
            prev1=curr;
        }
        return curr;
    }
}
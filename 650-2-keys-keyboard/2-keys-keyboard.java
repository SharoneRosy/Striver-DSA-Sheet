class Solution {
    public int minSteps(int n) {
        int curr=1;
        int ans=0;
        int curr_copy=0;
        while(curr<n){
            if(n%curr==0){
                curr_copy=curr;
                ans++;
            }
            curr+=curr_copy;
            ans++;
        }
        return ans;
        
    }
}
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int res[]=new int[n-k+1];
        int l=0,r=0;
        int t=0;
        Deque<Integer>dq=new LinkedList<>();
        while(r<n){
            while(!dq.isEmpty() && nums[dq.peekLast()]<nums[r]){
                dq.pollLast();
            }
            dq.addLast(r);

            if(r-l+1==k){
                res[t++]=nums[dq.peekFirst()];
                l++;
                if(dq.peekFirst()<l){
                    dq.pollFirst();
                }
            }

            if(r-l+1<k){
                r++;
            }
        }
        return res;
    }
}
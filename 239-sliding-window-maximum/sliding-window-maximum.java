class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int res[]=new int[n-k+1];
        Deque<Integer> dq=new LinkedList<>();
        int i=0,j=0;
        int t=0;
        while(j<n)
        {
            // Calculation
            while(!dq.isEmpty() && nums[dq.peekLast()]<nums[j])
            {
                dq.pollLast();
            }
            dq.offerLast(j);
            
            // when  the window size is equal to K
            if(j-i+1==k)
            {
                // Using the Calculation to take out the ans
                res[t++]=nums[dq.peekFirst()];
                i++;
                if(dq.peekFirst()<i)
                    dq.pollFirst();
            }
            //when we don't reach the window size just increment j
            if((j-i+1)<k)
                j++;
        }
        return res;
    }
}
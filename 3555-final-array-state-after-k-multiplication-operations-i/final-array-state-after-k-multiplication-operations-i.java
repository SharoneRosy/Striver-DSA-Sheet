class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<int []>minHeap=new PriorityQueue<>((a,b)->
        {
            if(a[0]==b[0]){
                return Integer.compare(a[1],b[1]);
            }
            return Integer.compare(a[0],b[0]);
        });
        for(int i=0;i<nums.length;i++){
            minHeap.add(new int[]{nums[i],i});
        }
        while(k-->0){
            int[] curr=minHeap.poll();
            curr[0]*=multiplier;
            nums[curr[1]]*=multiplier;
            minHeap.offer(curr);
        }
        return nums;
    }
}
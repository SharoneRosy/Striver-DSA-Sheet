
import java.util.stream.IntStream;
class Solution {
    
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        for(int i=0;i<k;i++){
            // int minIndex=IntStream.range(0,nums.length).reduce((a,b)->nums[a]<=nums[b]:a?b).orElse(-1);
            int minIndex = IntStream.range(0, nums.length)
                    .reduce((a, b) -> nums[a] <= nums[b] ? a : b)
                    .orElse(-1);
            nums[minIndex]*=multiplier;
        }
        return nums;
    }
}
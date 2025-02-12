import java.util.*;

class Solution {
    public int findPairs(int[] nums, int k) {
        if (k < 0) return 0; // No valid pairs if k is negative
        
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;

        // Step 1: Store frequency of each number
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Step 2: Check for unique k-diff pairs
        for (int num : map.keySet()) {
            if (k == 0) {
                // Count numbers appearing at least twice
                if (map.get(num) > 1) count++;
            } else {
                // If num + k exists, count it as a valid pair
                if (map.containsKey(num + k)) count++;
            }
        }

        return count;
    }
}

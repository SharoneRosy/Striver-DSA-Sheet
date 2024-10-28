class Solution {
    public int longestSquareStreak(int[] nums) {
        // Space: O(N) for HashSet
        HashSet<Long> set = new HashSet<>();
        
        // Time: O(N) for initial HashSet population
        for (int num : nums) {
            set.add((long)num);
        }
        
        int maxLength = -1;
        
        // Time: O(N) * O(loglogM) for checking each number's streak
        for (int num : nums) {
            int currentLength = 1;
            long current = num;
            
            // This while loop runs O(loglogM) times because of how quickly squares grow
            while (current <= 100000 && set.contains(current * current)) {
                currentLength++;
                current = current * current;
            }
            
            if (currentLength >= 2) {
                maxLength = Math.max(maxLength, currentLength);
            }
        }
        
        return maxLength;
    }
}
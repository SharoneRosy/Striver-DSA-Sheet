class Solution {
    public int[] constructDistancedSequence(int n) {
        int[] result = new int[2 * n - 1];
        boolean[] used = new boolean[n + 1]; // To track used numbers
        backtrack(result, used, n, 0);
        return result;
    }

    private boolean backtrack(int[] result, boolean[] used, int n, int index) {
        if (index == result.length) {
            return true; // Successfully filled the sequence
        }

        if (result[index] != 0) {
            return backtrack(result, used, n, index + 1); // Skip if already filled
        }

        // Try to place numbers from n down to 1
        for (int num = n; num >= 1; num--) {
            if (!used[num]) {
                // Check if we can place num at index
                if (num == 1) {
                    result[index] = num;
                    used[num] = true;
                } else {
                    int nextIndex = index + num; // The position for the second occurrence
                    if (nextIndex < result.length && result[nextIndex] == 0) {
                        // Place the number
                        result[index] = num;
                        result[nextIndex] = num;
                        used[num] = true;
                    } else {
                        continue; // Skip if cannot place the second occurrence
                    }
                }

                // Recur to fill the next position
                if (backtrack(result, used, n, index + 1)) {
                    return true; // Found a valid sequence
                }

                // Backtrack
                result[index] = 0;
                if (num == 1) {
                    used[num] = false;
                } else {
                    int nextIndex = index + num;
                    result[nextIndex] = 0;
                    used[num] = false;
                }
            }
        }

        return false; // No valid placement found
    }
}
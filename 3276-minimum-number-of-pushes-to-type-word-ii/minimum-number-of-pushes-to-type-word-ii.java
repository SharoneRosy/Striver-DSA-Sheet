class Solution {
    public int minimumPushes(String word) {
        // Greedy Sorting of Frequency Count
        // TC: O(n), SC: O(1)
        int[] freq = new int[26];
        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }
        Arrays.sort(freq);
        int ans = 0;
        for (int i = 0; i < 26; i++) {
            // The top 8 frequent characters are put at the first of each key
            // the next 8 most frequent characters are put at the second of each key, etc
            int j = 25 - i;
            ans += freq[i] * (j / 8 + 1);
        }
        return ans;
    }
}
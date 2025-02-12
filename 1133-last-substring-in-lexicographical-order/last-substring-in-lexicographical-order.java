class Solution {
    public String lastSubstring(String s) {
        int n = s.length();
        int i = 0, j = 1, k = 0; // i is the best suffix index found so far, j is scanning, k is the comparison offset

        while (j + k < n) {
            if (s.charAt(i + k) == s.charAt(j + k)) {
                k++; // If characters are the same, move forward in both suffixes
                continue;
            }

            if (s.charAt(i + k) < s.charAt(j + k)) {
                // If the current suffix starting at j is better, update i to j
                i = Math.max(i + k + 1, j);
                j = i + 1; // Move j to start right after the new i
            } else {
                // If current suffix at j is worse, move j ahead
                j = j + k + 1;
            }
            k = 0; // Reset k for fresh comparison
        }

        return s.substring(i); // The largest lexicographical suffix starts at index i
    }
}

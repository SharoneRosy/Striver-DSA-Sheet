class Solution {
    public int findTheLongestSubstring(String s) {
        int[] map = new int[32];
        Arrays.fill(map, -2);
        map[0] = -1;
        int n = s.length(), mask = 0, len = 0;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') mask ^= 1 << (4 -
                    (ch == 'a' ? 0 : ch == 'e' ? 1 : ch == 'i' ? 2 : ch == 'o' ? 3 : 4));
            if (map[mask] == -2) map[mask] = i;
            else len = Math.max(len, i - map[mask]);
        }
        return len;
    }
}
class Solution {
    public String minWindow(String s, String t) {
        int n = s.length(), m = t.length();
        int minLength = Integer.MAX_VALUE, count = 0;
        int left = 0, right = 0, startIndex = -1;
        HashMap<Character, Integer> seen = new HashMap<>();

        for (char c : t.toCharArray()) {
            seen.put(c, seen.getOrDefault(c, 0) + 1);
        }

        while (right < n) {
            if (seen.getOrDefault(s.charAt(right), 0) > 0) count++;
            seen.put(s.charAt(right), seen.getOrDefault(s.charAt(right), 0) - 1);

            while (count == m) {
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    startIndex = left;
                }

                seen.put(s.charAt(left), seen.getOrDefault(s.charAt(left), 0) + 1);
                if (seen.get(s.charAt(left)) > 0) count--;
                left++;
            }
            right++;
        }

        return (startIndex == -1) ? "" : s.substring(startIndex, startIndex + minLength);
    }
}
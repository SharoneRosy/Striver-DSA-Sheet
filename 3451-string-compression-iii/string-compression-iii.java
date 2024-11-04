class Solution {
    public String compressedString(String word) {
        StringBuilder ans = new StringBuilder();
        int i = 0;
        while (i < word.length()) {
            char c = word.charAt(i);
            int j = i, cnt = 0;
            while (j < word.length() && word.charAt(j) == c && cnt < 9) {
                cnt++;
                j++;
            }
            ans.append(cnt);
            ans.append(c);
            i = j;
        }
        return ans.toString();
    }
}
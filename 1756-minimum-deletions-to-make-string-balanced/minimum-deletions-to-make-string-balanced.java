class Solution {
    public int minimumDeletions(String s) {
        int a_cnt = 0;
        int b_cnt = 0;
        for (char ch : s.toCharArray()) {
            if (ch == 'a') {
                b_cnt++;
            } else {
                b_cnt = Math.min(b_cnt, a_cnt);
                a_cnt++;
            }
        }
        return a_cnt > b_cnt ? b_cnt : a_cnt;

    }
}
public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int l = 1, r = n;
        while (true) {
            int m = l + (r - l) / 2;
            int res = guess(m);
            if (res > 0) {
                l = m + 1;
            } else if (res < 0) {
                r = m - 1;
            } else {
                return m;
            }
        }
    }
}
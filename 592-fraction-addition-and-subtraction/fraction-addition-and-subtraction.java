class Solution {
    public String fractionAddition(String expression) {
        int numerator = 0, denominator = 1; // Start with 0/1

        int i = 0, n = expression.length();
        while (i < n) {
            // Read sign
            int sign = 1;
            if (expression.charAt(i) == '-' || expression.charAt(i) == '+') {
                sign = (expression.charAt(i) == '-') ? -1 : 1;
                i++;
            }

            // Read numerator
            int num = 0;
            while (i < n && Character.isDigit(expression.charAt(i))) {
                num = num * 10 + (expression.charAt(i) - '0');
                i++;
            }

            // Skip '/'
            i++;

            // Read denominator
            int denom = 0;
            while (i < n && Character.isDigit(expression.charAt(i))) {
                denom = denom * 10 + (expression.charAt(i) - '0');
                i++;
            }

            // Update fraction
            numerator = numerator * denom + sign * num * denominator;
            denominator *= denom;

            // Reduce fraction
            int gcd = gcd(Math.abs(numerator), denominator);
            numerator /= gcd;
            denominator /= gcd;
        }

        return numerator + "/" + denominator;
    }

    // Helper function to calculate GCD
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}

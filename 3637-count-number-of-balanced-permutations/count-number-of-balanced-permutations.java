class Solution {
    private static final int MODULUS = 1_000_000_007;
    private static final int MAX_DIGITS = 41;
    private static final long[] factorials = new long[MAX_DIGITS];
    private static final long[] inverseFactorials = new long[MAX_DIGITS];
    
    static {
        initializeFactorials();
        initializeInverseFactorials();
    }
    
    private static void initializeFactorials() {
        factorials[0] = 1;
        for (int i = 1; i < MAX_DIGITS; i++) {
            factorials[i] = factorials[i - 1] * i % MODULUS;
        }
    }
    
    private static void initializeInverseFactorials() {
        inverseFactorials[MAX_DIGITS - 1] = modularPow(factorials[MAX_DIGITS - 1], MODULUS - 2);
        for (int i = MAX_DIGITS - 1; i > 0; i--) {
            inverseFactorials[i - 1] = inverseFactorials[i] * i % MODULUS;
        }
    }
    
    public int countBalancedPermutations(String number) {
        int[] digitFrequencies = calculateDigitFrequencies(number);
        int totalDigitSum = calculateTotalDigitSum(number);
        
        if (totalDigitSum % 2 != 0) {
            return 0;
        }
        
        for (int i = 1; i < 10; i++) {
            digitFrequencies[i] += digitFrequencies[i - 1];
        }
        
        int totalLength = number.length();
        int halfLength = totalLength / 2;
        
        int[][][] memoizationTable = initializeMemoizationTable(halfLength, totalDigitSum);
        
        return (int) (factorials[halfLength] * 
                     factorials[totalLength - halfLength] % MODULUS * 
                     computeBalancedPermutations(9, halfLength, totalDigitSum / 2, digitFrequencies, memoizationTable) % MODULUS);
    }
    
    private int[] calculateDigitFrequencies(String number) {
        int[] frequencies = new int[10];
        for (char digit : number.toCharArray()) {
            frequencies[digit - '0']++;
        }
        return frequencies;
    }
    
    private int calculateTotalDigitSum(String number) {
        int sum = 0;
        for (char digit : number.toCharArray()) {
            sum += digit - '0';
        }
        return sum;
    }
    
    private int[][][] initializeMemoizationTable(int halfLength, int totalDigitSum) {
        int[][][] memo = new int[10][halfLength + 1][totalDigitSum / 2 + 1];
        for (int[][] matrix : memo) {
            for (int[] row : matrix) {
                Arrays.fill(row, -1);
            }
        }
        return memo;
    }
    
    private int computeBalancedPermutations(int digit, int remainingLeft, int remainingSum, 
                                             int[] digitFrequencies, int[][][] memoizationTable) {
        if (digit < 0) {
            return remainingSum == 0 ? 1 : 0;
        }
        
        if (memoizationTable[digit][remainingLeft][remainingSum] != -1) {
            return memoizationTable[digit][remainingLeft][remainingSum];
        }
        
        long result = 0;
        int currentDigitCount = digitFrequencies[digit] - (digit > 0 ? digitFrequencies[digit - 1] : 0);
        int remainingRightCount = digitFrequencies[digit] - remainingLeft;
        
        for (int k = Math.max(currentDigitCount - remainingRightCount, 0); 
             k <= Math.min(currentDigitCount, remainingLeft) && k * digit <= remainingSum; 
             k++) {
            long subResult = computeBalancedPermutations(digit - 1, 
                                                          remainingLeft - k, 
                                                          remainingSum - k * digit, 
                                                          digitFrequencies, 
                                                          memoizationTable);
            result = (result + subResult * inverseFactorials[k] % MODULUS * 
                     inverseFactorials[currentDigitCount - k]) % MODULUS;
        }
        
        memoizationTable[digit][remainingLeft][remainingSum] = (int) result;
        return (int) result;
    }
    
    private static long modularPow(long base, int exponent) {
        long result = 1;
        while (exponent > 0) {
            if (exponent % 2 == 1) {
                result = result * base % MODULUS;
            }
            base = base * base % MODULUS;
            exponent /= 2;
        }
        return result;
    }
}
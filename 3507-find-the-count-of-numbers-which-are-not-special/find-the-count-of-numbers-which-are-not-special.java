import java.util.ArrayList;
import java.util.List;

class Solution {
    // Function to generate prime numbers using Sieve of Eratosthenes
    public List<Integer> sieveOfEratosthenes(int max) {
        boolean[] isPrime = new boolean[max + 1];
        for (int i = 2; i <= max; i++) isPrime[i] = true;
        
        for (int p = 2; p * p <= max; p++) {
            if (isPrime[p]) {
                for (int i = p * p; i <= max; i += p) {
                    isPrime[i] = false;
                }
            }
        }
        
        List<Integer> primes = new ArrayList<>();
        for (int p = 2; p <= max; p++) {
            if (isPrime[p]) primes.add(p);
        }
        
        return primes;
    }

    // Function to count non-special numbers in the range [l, r]
    public int nonSpecialCount(int l, int r) {
        int sqrtR = (int) Math.sqrt(r);
        List<Integer> primes = sieveOfEratosthenes(sqrtR);
        
        int specialCount = 0;
        for (int prime : primes) {
            int primeSquare = prime * prime;
            if (primeSquare >= l && primeSquare <= r) {
                specialCount++;
            }
        }
        
        return (r - l + 1 - specialCount);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.nonSpecialCount(5, 7)); // Output: 3
        System.out.println(solution.nonSpecialCount(4, 16)); // Output: 11
    }
}

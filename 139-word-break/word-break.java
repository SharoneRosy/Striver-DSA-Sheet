import java.util.*;

public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        return tabulation(s, wordSet);
    }
    
    private boolean recursive(int i, String s, Set<String> wordSet) {
        if (i > s.length() - 1) {
            return true;
        }
        
        for (int j = i; j < s.length(); j++) {
            if (wordSet.contains(s.substring(i, j + 1)) && recursive(j + 1, s, wordSet)) {
                return true;
            }
        }
        
        return false;
    }

    private boolean memoized(int i, String s, Set<String> wordSet, Map<Integer, Boolean> memo) {
        if (i > s.length() - 1) {
            return true;
        }
        
        if (memo.containsKey(i)) {
            return memo.get(i);
        }
        
        for (int j = i; j < s.length(); j++) {
            if (wordSet.contains(s.substring(i, j + 1)) && recursive(j + 1, s, wordSet)) {
                memo.put(i, true);
                return true;
            }
        }
        
        memo.put(i, false);
        return false;
    }

    private boolean tabulation(String s, Set<String> wordSet) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                String currentWord = s.substring(j, i);
                dp[i] = dp[j] && wordSet.contains(currentWord);
                if (dp[i]) {
                    break;
                }
            }
        }
        
        return dp[s.length()];
    }
}
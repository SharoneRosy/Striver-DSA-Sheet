import java.util.*;

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        // Convert paragraph to lowercase and replace punctuation with spaces
        paragraph = paragraph.toLowerCase().replaceAll("[!?',;\\.]", " ");
        
        // Split paragraph into words
        String[] words = paragraph.split("\\s+");

        // Store banned words in a set for quick lookup
        Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));

        // Map to count frequency of words
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            if (!bannedSet.contains(word)) {
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            }
        }

        // Find the most frequent non-banned word
        String mostCommon = "";
        int maxFreq = 0;
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            if (entry.getValue() > maxFreq) {
                maxFreq = entry.getValue();
                mostCommon = entry.getKey();
            }
        }

        return mostCommon;
    }
}

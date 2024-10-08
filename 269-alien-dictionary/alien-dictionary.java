public class Solution {
    public String alienOrder(String[] words) {
        // Step 1: Initialize the adjacency list for all characters
        Map<Character, Set<Character>> adj = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                adj.put(c, new HashSet<>());
                indegree.put(c, 0);
            }
        }

        // Step 2: Build the graph by comparing adjacent words
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            int minLength = Math.min(word1.length(), word2.length());
            boolean foundDifference = false;
            for (int j = 0; j < minLength; j++) {
                char c1 = word1.charAt(j);
                char c2 = word2.charAt(j);
                if (c1 != c2) {
                    if (!adj.get(c1).contains(c2)) {
                        adj.get(c1).add(c2);
                        indegree.put(c2, indegree.get(c2) + 1);
                    }
                    foundDifference = true;
                    break; // Stop once the first difference is found
                }
            }
            if (!foundDifference && word1.length() > word2.length()) {
                // Edge case: If word1 is longer and comes before word2, return "".
                return "";
            }
        }

        // Step 3: Perform topological sort using BFS (Kahn's Algorithm)
        Queue<Character> q = new LinkedList<>();
        for (char c : indegree.keySet()) {
            if (indegree.get(c) == 0) {
                q.add(c);
            }
        }

        StringBuilder result = new StringBuilder();
        while (!q.isEmpty()) {
            char c = q.poll();
            result.append(c);
            for (char neighbor : adj.get(c)) {
                indegree.put(neighbor, indegree.get(neighbor) - 1);
                if (indegree.get(neighbor) == 0) {
                    q.add(neighbor);
                }
            }
        }

        // Step 4: Check if there was a cycle
        if (result.length() != indegree.size()) {
            return "";
        }

        return result.toString();
    }
}

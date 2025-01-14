class Solution {
    Map<String, Integer> distance = new HashMap<>();
    List<List<String>> result = new ArrayList<>();
    String startWord;

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        wordSet.remove(beginWord);

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        distance.put(beginWord, 1);
        startWord = beginWord;

        while (!queue.isEmpty()) {
            String currentWord = queue.poll();
            if (currentWord.equals(endWord)) break;

            for (int i = 0; i < currentWord.length(); i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    char[] wordChars = currentWord.toCharArray();
                    wordChars[i] = ch;
                    String transformedWord = new String(wordChars);

                    if (wordSet.contains(transformedWord)) {
                        wordSet.remove(transformedWord);
                        queue.add(transformedWord);
                        distance.put(transformedWord, distance.get(currentWord) + 1);
                    }
                }
            }
        }

        if (distance.containsKey(endWord)) {
            List<String> path = new ArrayList<>();
            path.add(endWord);
            backtrack(endWord, path);
        }

        return result;
    }

    private void backtrack(String word, List<String> path) {
        if (word.equals(startWord)) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < word.length(); i++) {
            for (char ch = 'a'; ch <= 'z'; ch++) {
                char[] wordChars = word.toCharArray();
                wordChars[i] = ch;
                String transformedWord = new String(wordChars);

                if (distance.containsKey(transformedWord) && distance.get(transformedWord) == distance.get(word) - 1) {
                    path.add(0, transformedWord); // Add to the start of the path
                    backtrack(transformedWord, path);
                    path.remove(0); // Remove to backtrack
                }
            }
        }
    }
}

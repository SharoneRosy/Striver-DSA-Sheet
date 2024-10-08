class Solution {
    Map<String, Integer> map = new HashMap();
    List<List<String>> ans = new ArrayList();
    String begin;

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet(wordList);
        set.remove(beginWord);
        Queue<String> q = new LinkedList();
        q.add(beginWord);
        map.put(beginWord, 1);
        begin = beginWord;

        while(!q.isEmpty()) {
            String word = q.poll();
            if(word.equals(endWord))  break;

            for(int i=0; i<word.length(); i++) {
                for(char ch='a'; ch<='z'; ch++) {
                    char[] curr = word.toCharArray();
                    curr[i] = ch;
                    String replacedWord = new String(curr);

                    if(set.contains(replacedWord)) {
                        set.remove(replacedWord);
                        q.add(replacedWord);
                        map.put(replacedWord, map.get(word)+1);
                    }
                }
            }
        }
        if(map.containsKey(endWord)) {
            List<String> seq = new ArrayList();
            seq.add(endWord);
            dfs(endWord, seq);
        }
        return ans;
    }

    public void dfs(String word, List<String> seq) {
        if(word.equals(begin)) {
            ans.add(new ArrayList(seq));
            return;
        }

        for(int i=0; i<word.length(); i++) {
            for(char ch='a'; ch<='z'; ch++) {
                char[] curr = word.toCharArray();
                curr[i] = ch;
                String replacedWord = new String(curr);

                if(map.containsKey(replacedWord) && map.get(replacedWord) == map.get(word)-1) {
                    seq.add(0, replacedWord);   // add replacedWord in start
                    dfs(replacedWord, seq);
                    seq.remove(0);              // remove replacedWord to backtrack
                }
            }
        }
    }
}
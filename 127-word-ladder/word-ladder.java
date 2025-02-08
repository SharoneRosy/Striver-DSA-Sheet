class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String>wordSet=new HashSet<>(wordList);
        if(!wordSet.contains(endWord)) return 0;

        Queue<String>q=new LinkedList<>();
        q.add(beginWord);
        int steps=1;

        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                String word=q.poll();
                if(word.equals(endWord)) return steps;

                char[] wordChars=word.toCharArray();
                for(int j=0;j<wordChars.length;j++){
                    char originalChar=wordChars[j];
                    for(char c='a';c<='z';c++){
                        wordChars[j]=c;
                        String newWord=new String(wordChars);
                        if(wordSet.contains(newWord)){
                            q.add(newWord);
                            wordSet.remove(newWord);
                        }
                    }
                    wordChars[j]=originalChar;
                }
            }
              steps++;
        }
        return 0;
    }
}